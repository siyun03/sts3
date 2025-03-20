package jdbcboard.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import jdbcboard.dao.impl.ArticleDAOImpl;
import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;
import jdbcboard.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private static ArticleServiceImpl articleServiceImpl = new ArticleServiceImpl();
	private ArticleDAOImpl articleDAOImpl;
	
	private ArticleServiceImpl() {
		articleDAOImpl = ArticleDAOImpl.getArticleDAOImpl();
	}
	
	public static ArticleServiceImpl getArticleServiceImpl() {
		return articleServiceImpl;
	}
	
	@Override
	public List<Article> selectArticle(ArticleCriteria articleCriteria) {
		return articleDAOImpl.selectArticle(articleCriteria);
	}
	
	@Override
	public Article getArticle(int aid) {
		return articleDAOImpl.getArticle(aid);
	}
	
	@Override
	public int insertArticle(Article article) {
		return articleDAOImpl.insertArticle(article);
	}
	
	@Override
	public int updateArticle(Article article) {
		return articleDAOImpl.updateArticle(article);
	}
	
	@Override
	public int deleteArticle(int aid) {
		return articleDAOImpl.deleteArticle(aid);
	}
	
	@Override
	public int increaseAvcnt(int aid) {
		return articleDAOImpl.increaseAvcnt(aid);
	}
	
	@Override
	public int getSequenceNextVal() {
		return articleDAOImpl.getSequenceNextVal();
	}
	
	@Override
	public int getTotalRowCount(ArticleCriteria articleCriteria) {
		return articleDAOImpl.getTotalRowCount(articleCriteria);
	}

}






