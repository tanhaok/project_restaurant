package com.hcmute.controller.user;

import com.hcmute.dao.CommentDao;
import com.hcmute.model.CommentModel;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CommentController {
    private CommentDao commentDao = new CommentDao();

    @RequestMapping(value = {"/insert-comment/{productId}"}, method = RequestMethod.POST)
    public boolean insertComment(HttpServletRequest req, @PathVariable int productId, ModelMap modelMap){
        int cusId = Integer.parseInt(req.getParameter("cusId"));
        String content = req.getParameter("content");
        System.out.println(content);

        if(content == null) {
            return false;
        }

        CommentModel comment = new CommentModel();
        comment.setComment(content);
        comment.setProductId(productId);
        comment.setUserId(cusId);

        return commentDao.insertNewComment(comment);

    }

    @RequestMapping(value = {"/delete-comment/{commentId}"}, method = RequestMethod.GET)
    public boolean deleteComment(@PathVariable int commentId){
        return commentDao.deleteComment(commentId);
    }

    @RequestMapping(value = {"/update-comment/{commentId}"}, method = RequestMethod.PUT)
    public boolean updateComment(@PathVariable int commentId, HttpServletRequest req){
        return commentDao.updateComment(commentId, req.getParameter("content"));
    }

    @RequestMapping(value = {"/get-comment/{productId}"}, method = RequestMethod.GET)
    public void getAllComment(@PathVariable int productId){
        List<CommentModel> list = commentDao.getALlCommentById(productId);
        // do some thing
    }
}
