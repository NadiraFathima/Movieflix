package training.egen.rest.service;


import java.util.List;

import training.egen.rest.entity.RatingsComments;

public interface RatingsCommentsService {

	public Double findavgratings(String titleId);
	public List<String> findComments(String titleId);
	public RatingsComments create(RatingsComments r, String titleId);
	public void delete(String ratingId);
}
