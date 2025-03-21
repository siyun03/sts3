package jdbcboard.dao;

import java.util.List;

import jdbcboard.model.Article;
import jdbcboard.model.ArticleCriteria;

public interface ArticleDAO {
	
	default List<Article> selectArticle(ArticleCriteria articleCriteria) { return null; }
	
	default Article getArticle(int aid) { return null; }
	
	default int insertArticle(Article article) { return 0; }
	
	default int updateArticle(Article article) { return 0; }
	
	default int deleteArticle(int aid) { return 0; }		
	
	default int increaseAvcnt(int aid) { return 0; }
	
	default int getSequenceNextVal() { return 0; }	
	
	default int getTotalRowCount(ArticleCriteria articleCriteria) { return 0; }

}
