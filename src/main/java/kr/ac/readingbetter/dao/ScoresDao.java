package kr.ac.readingbetter.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.readingbetter.vo.HistoryVo;
import kr.ac.readingbetter.vo.ScoresVo;

@Repository
public class ScoresDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체 랭킹
	public List<ScoresVo> monthlyRank(ScoresVo vo) {
		return sqlSession.selectList("scores.monthlyRank", vo);
	}

	// 로그인 한 회원 전체 랭킹
	public ScoresVo mymonthlyRank(Long no) {
		return sqlSession.selectOne("scores.myMonthlyRank", no);
	}

	// 학교 랭킹
	// 로그인 한 회원의 학교 랭킹
	public ScoresVo mySchoolRank(Integer no) {
		return sqlSession.selectOne("scores.mySchoolRank", no);
	}

	// 학년 랭킹
	/*
	 * public List<ScoresVo> gradeRank(ScoresVo vo) { return null; }
	 */

	// 명예의 전당
	public List<ScoresVo> honor(ScoresVo vo) {
		return sqlSession.selectList("scores.honor", vo);
	}

	// 로그인 한 회원의 명예의 전당
	public ScoresVo myTotalRank(Long no) {
		return sqlSession.selectOne("scores.myTotalRank", no);
	}

	// 명예의 전당 Top 3
	public List<ScoresVo> totalTopRanker(ScoresVo vo) {
		return sqlSession.selectList("scores.totalTopRanker", vo);
	}

	public List<ScoresVo> schoolRank(ScoresVo vo) {
		return sqlSession.selectList("scores.schoolRank", vo);
	}

	public void updateScores(HistoryVo vo) {
		sqlSession.update("scores.updateScores", vo);
	}
}