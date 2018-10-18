package bussiness.spider.controller;

import bussiness.spider.domain.Article;
import bussiness.spider.domain.SpiderStatus;
import bussiness.spider.service.ArticleService;
import bussiness.spider.service.SpiderStatusService;
import com.zsd.comm.orm.Page;
import com.zsd.comm.utils.ControllerUtils;
import com.zsd.comm.utils.JsonMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.*;

/**
 * 作协活动控制器.
 * @author zhousd
 */
@Controller
@RequestMapping("article")
public class ArticleController {

    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SpiderStatusService spiderStatusService;

    private JsonMapper jsonMapper = new JsonMapper();

    /**
     * 查询列表.
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView gotoPageOne() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("spiderStatus", spiderStatusService.get());
        mv.setViewName("article/list");
        return mv;
    }

    /**
     * 分页。
     */
    @RequestMapping(value = "search", produces = "text/plain; charset=UTF-8")
    @ResponseBody
    public String search(@RequestParam(required = false) String keyWord,
                         @RequestParam(required = false) Integer pageNo,
                         @RequestParam(required = false) Integer pageSize) {

        Page<Article> page = new Page<>();
        if (pageNo != null && pageSize != null) {
            page.setPageNo(pageNo);
            page.setPageSize(pageSize);
        }

        Map<String, Object> param = new HashMap<>();
        param.put("keyWord", keyWord);

        page = articleService.search(page, param);
        String ret = jsonMapper.toJson(page);
        return ret;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> delete(String idStr) {
        logger.debug("delete ids : {}", idStr);
        try {
            articleService.deleteByIds(idStr);
            return ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "删除成功!");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "删除失败!");
        }
    }

    @RequestMapping(value = "spider", method = RequestMethod.GET)
    public void spider() {
        try {
            spiderStatusService.updateStatus(SpiderStatus.STATUS_EXEING);
            articleService.spider();
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            spiderStatusService.updateStatus(SpiderStatus.STATUS_NOEXE);
        }
    }

    @RequestMapping(value = "export/{days}", method = RequestMethod.GET)
    public void export(@PathVariable("days") String days, HttpServletRequest request, HttpServletResponse response) {
        String[] headers = { "标题", "来源链接", "来源网站", "发布日期", "内容", "采集时间", "备注"};
        List<Article> articleList = articleService.getByTime(days);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
//        //设置列宽
//        sheet.setDefaultColumnWidth((short) 18);
        //创建第一行的对象，第一行一般用于填充标题内容。从第二行开始一般是数据
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            //创建单元格，每行多少数据就创建多少个单元格
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            //给单元格设置内容
            cell.setCellValue(text);
        }
        //遍历集合，将每个集合元素对象的每个值填充到单元格中
        for(int i=0; i<articleList.size(); i++){
            Article article = articleList.get(i);
            //从第二行开始填充数据
            row = sheet.createRow(i+1);
            //该集合只记录数量和时间，这两个值来自statisticsModel。如果对象比较复杂，需要额外转换，比如Date类型的日期，int，float类型的数值
            List<String> datas=new ArrayList<>();
            String title = article.getName();
            String fromUrl = article.getFromUrl();
            String fromWeb = article.getFromWeb();
            String publishDateStr = DateFormat.getDateInstance(DateFormat.FULL).format(article.getPublishDate());
            String content = article.getContent();
            String remark = article.getRemark();
            String createTimeStr = DateFormat.getDateInstance(DateFormat.FULL).format(article.getCreateTime());
            datas.add(title);
            datas.add(fromUrl);
            datas.add(fromWeb);
            datas.add(publishDateStr);
            datas.add(content);
            datas.add(createTimeStr);
            datas.add(remark);
            for (int j=0; j<datas.size(); j++) {
                String string=datas.get(j);
                HSSFCell cell = row.createCell(j);
                HSSFRichTextString richString = new HSSFRichTextString(string);
                HSSFFont font3 = workbook.createFont();
                richString.applyFont(font3);
                cell.setCellValue(richString);
            }
        }
        response.setContentType("application/octet-stream");
        days = StringUtils.equals("100000", days) ? "all" : days;
        StringBuilder fileName = new StringBuilder("attachment;filename=");
        fileName.append("Article")
                .append(DateFormat.getDateInstance(DateFormat.DEFAULT).format(new Date()))
                .append("[").append(days).append("]")
                .append(".xls");
        response.setHeader("Content-disposition", fileName.toString()); //Excel文件名
        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream()); //将workbook中的内容写入输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
