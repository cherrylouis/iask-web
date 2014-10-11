package com.downjoy.iask.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.downjoy.iask.domain.KeyWords;
import com.downjoy.ikanalyzer.DictionaryLoader;

public class IKAnalzyerUtil {
	static Logger logger = Logger.getLogger(IKAnalzyerUtil.class);
	static Analyzer analyzer = new IKAnalyzer(true);

	public static List<KeyWords> getTerm(String q) {
		List<KeyWords> list = new ArrayList<KeyWords>();
		List<KeyWords> words = DictionaryLoader.getSingleton().getWords();
		List<String> wordStrs = DictionaryLoader.getSingleton().getWordStrs();
		logger.info("words length : " + words.size());
		TokenStream ts = null;
		try {
			logger.info("tokenStream start ");
			ts = analyzer.tokenStream("myfield", new StringReader(q));
			CharTermAttribute term = (CharTermAttribute) ts
					.addAttribute(CharTermAttribute.class);
			ts.reset();
			String termStr = null;
			int index = 0;
			while (ts.incrementToken()) {
				termStr = term.toString();
				if (wordStrs != null && wordStrs.size() > 0
						&& wordStrs.contains(termStr)) {
					index = wordStrs.indexOf(termStr);
					list.add(words.get(index));
				}
			}
			ts.end();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			if (ts != null)
				try {
					ts.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
}
