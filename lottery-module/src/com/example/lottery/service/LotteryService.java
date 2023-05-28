package com.example.lottery.service;

import java.util.List;

/**
*
*  @author Binnur Kurt <binnur.kurt@gmail.com>
*/
public interface LotteryService {
	List<Integer> draw(int max,int size);
	List<List<Integer>> draw(int max,int size,int column);
}
