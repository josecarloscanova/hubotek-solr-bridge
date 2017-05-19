package org.hubotek.solr.client.query.param;

import org.hubotek.solr.client.query.SolrQueryCommonEnum;

/**
 * 
 * 
 * 
 * @author JoseCanova
 *
 */
public class QueryParameter {
	
	private SolrQueryCommonEnum queryParameterEnum;
	
	private String parameter;
	
	public QueryParameter() {
	}

	public SolrQueryCommonEnum getQueryParameterEnum() {
		return queryParameterEnum;
	}

	public void setQueryParameterEnum(SolrQueryCommonEnum queryParameterEnum) {
		this.queryParameterEnum = queryParameterEnum;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}
