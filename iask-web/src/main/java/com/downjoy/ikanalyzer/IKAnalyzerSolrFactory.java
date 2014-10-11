package com.downjoy.ikanalyzer;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource.AttributeFactory;
import org.wltea.analyzer.lucene.IKTokenizer;

/**
 * @author lxw
 *	自定义的一个TokenizerFactory，主要是用于配置useSmart，直接配置Tokenizer的useSmart不起作用
 */
public class IKAnalyzerSolrFactory extends TokenizerFactory {

	private boolean useSmart;

	public boolean useSmart() {
		return useSmart;
	}

	public void setUseSmart(boolean useSmart) {
		this.useSmart = useSmart;
	}

	public IKAnalyzerSolrFactory(Map<String, String> args) {
		super(args);
		this.setUseSmart(args.get("useSmart").toString().equals("true"));
		System.out.println("useSmart:"+args.get("useSmart").toString().equals("true"));
	}

	@Override
	public Tokenizer create(AttributeFactory factory, Reader input) {
		Tokenizer _IKTokenizer = new IKTokenizer(input, this.useSmart);
		return _IKTokenizer;
	}

}
