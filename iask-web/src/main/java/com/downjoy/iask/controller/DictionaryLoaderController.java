package com.downjoy.iask.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import com.downjoy.iask.domain.KeyWords;
import com.downjoy.iask.exception.BaseException;
import com.downjoy.iask.service.KeyWordsRateService;
import com.downjoy.iask.util.IKAnalzyerUtil;
import com.downjoy.ikanalyzer.DictionaryLoader;

/**
 * @author lxw 使用spring的事件来完成扩展词典的加载，可以是从词典文件加入，也可以从数据库查询出来。
 */
@Controller
public class DictionaryLoaderController implements
		ApplicationListener<ContextRefreshedEvent> {

	@Autowired()
	@Qualifier("keyWordsRateService")
	private KeyWordsRateService keyWordsRateService;

	/**
	 * spring容器初始化完成后加载扩展词典，IKAnalzyer在整个生命周期中都要使用该词典
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			if (keyWordsRateService != null) {
				System.out.println("加载扩展词典");
				List<KeyWords> words = keyWordsRateService.select();
				if (words != null && words.size() > 0) {
					DictionaryLoader.getSingleton().addWords(words);
					System.out.println("words size:" + words.size());
				}
			}
		} catch (BaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getDictionaryFromFile("dota.dic");
	}

	@SuppressWarnings("unused")
	private void getDictionaryFromFile(String fileName) {
		InputStream is = null;
		is = IKAnalzyerUtil.class.getClassLoader().getResourceAsStream(
				"fileName");
		List<KeyWords> words = new ArrayList<KeyWords>();
		KeyWords theWord = null;
		String wordStr = null;
		long id = 0L;
		if (is != null) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						is, "UTF-8"), 512);
				do {
					wordStr = br.readLine();
					if ((wordStr != null) && (!"".equals(wordStr.trim()))) {
						theWord = new KeyWords();
						theWord.setId(++id);
						theWord.setKeyWords(wordStr);
						words.add(theWord);

					}
				} while (theWord != null);
				DictionaryLoader.getSingleton().addWords(words);
			} catch (IOException ioe) {
				System.err.println("扩展词典加载错误.");
				ioe.printStackTrace();
			} finally {
				try {
					if (is != null) {
						is.close();
						is = null;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
