package bussiness.spider.controller;

import bussiness.spider.domain.Article;
import bussiness.spider.service.ArticleService;
import com.zsd.comm.orm.Page;
import com.zsd.comm.utils.ControllerUtils;
import com.zsd.comm.utils.JsonMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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

    private JsonMapper jsonMapper = new JsonMapper();

    /**
     * 查询列表.
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView gotoPageOne() {
        ModelAndView mv = new ModelAndView();
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
            articleService.delete(idStr);
            return ControllerUtils.responseBuilder(ControllerUtils.CODE_SUCCESS, "删除成功!");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            return ControllerUtils.responseBuilder(ControllerUtils.CODE_ERROR, "删除失败!");
        }
    }

    @RequestMapping(value = "spider", method = RequestMethod.GET)
    public void spider() {
        try {
            articleService.spider();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
