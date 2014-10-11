package com.downjoy.ikanalyzer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.cfg.DefaultConfig;
import org.wltea.analyzer.dic.Dictionary;

import com.downjoy.iask.domain.KeyWords;

/**
 * @author lxw 往词典中加上自定义的词典，主要是扩展IK的扩展词典功能 比如：读取数据库中的关键字并放入到词典中
 */
public class DictionaryLoader {
	public static DictionaryLoader loader = new DictionaryLoader();
	private List<KeyWords> words;
	private List<String> wordStrs;

	private DictionaryLoader() {
		Configuration cfg = DefaultConfig.getInstance(); // 加载词库
		cfg.setUseSmart(true); // 设置智能分词
		Dictionary.initial(cfg);
	}

	public static DictionaryLoader getSingleton() {
		return loader;
	}

	public void addWords(List<KeyWords> words) {
		List<String> wordStrs = new ArrayList<String>();
		if (words == null || words.size() < 1) {
			return;
		}
		for (KeyWords word : words) {
			if (StringUtils.isNotEmpty(word.getKeyWords())) {
				wordStrs.add(word.getKeyWords());
			} else {
				wordStrs.add("");
			}
		}
		this.words = words;
		this.wordStrs = wordStrs;
		Dictionary.getSingleton().addWords(wordStrs);
	}

	public List<KeyWords> getWords() {
		return words;
	}

	public void setWords(List<KeyWords> words) {
		this.words = words;
	}

	public static DictionaryLoader getLoader() {
		return loader;
	}

	public static void setLoader(DictionaryLoader loader) {
		DictionaryLoader.loader = loader;
	}

	public List<String> getWordStrs() {
		return wordStrs;
	}

	public void setWordStrs(List<String> wordStrs) {
		this.wordStrs = wordStrs;
	}

}
