package training.egen.rest.repository;

import java.util.List;

import training.egen.rest.entity.RatingsComments;

public interface RatingsCommentsRepository {
	public Double findavgratings(String titleId);
	public List<String> findComments(String titleId);
	public RatingsComments create(RatingsComments r);
	public void delete(String ratingId);
}
