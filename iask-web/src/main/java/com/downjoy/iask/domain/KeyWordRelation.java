package com.downjoy.iask.domain;

/**
 * @author lxw
 * 
 *         从数据库中查询出联想词构建的领域对象，没有关联某一张表，是sql中动态生成的数据，然后填充到这个model中
 */
public class KeyWordRelation {
	private Long id;
	private String target;
	private String source;
	private Long firstId;
	private Long sencondId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getFirstId() {
		return firstId;
	}

	public void setFirstId(Long firstId) {
		this.firstId = firstId;
	}

	public Long getSencondId() {
		return sencondId;
	}

	public void setSencondId(Long sencondId) {
		this.sencondId = sencondId;
	}

}
