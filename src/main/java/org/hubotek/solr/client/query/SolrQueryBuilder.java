package org.hubotek.solr.client.query;

import static org.hubotek.solr.client.query.SolrQueryCommonEnum.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hubotek.Builder;
import org.hubotek.model.solr.SolrQuery;
import org.hubotek.solr.util.FieldConcatOperator;
import org.hubotek.solr.util.QueryStringConcatOperator;

public class SolrQueryBuilder implements Builder<SolrQuery>{

	private List<String> paramList;

	public SolrQueryBuilder() {
		paramList = new ArrayList<String>();
	}

	
	public SolrQueryBuilder withQuery(String query)
	{ 
		verifyQueryEncoded(query);
		paramList.add(new StringBuilder().append(QUERY.getParam()).append('=').append(query).toString());
		return this;
	}
	
	
	private void verifyQueryEncoded(String query) {
		// TODO Check if query is correct regarding encoding parameter, and throw an Exception if not.
	}


	public SolrQueryBuilder withParser(String queryParser)
	{ 
		paramList.add(new StringBuilder().append(DEFTYPE.getParam()).append('=').append(queryParser).toString());
		return this;
	}
	
	public SolrQueryBuilder withFilterQuery(String filterQuery)
	{ 
		paramList.add(new StringBuilder().append(FQ.getParam()).append('=').append(filterQuery).toString());
		return this;
	}
	
	public SolrQueryBuilder withRows(String rows)
	{ 
		paramList.add(new StringBuilder().append(ROWS.getParam()).append('=').append(rows).toString());
		return this;
	}
	
	public SolrQueryBuilder withStart(String start)
	{ 
		paramList.add(new StringBuilder().append(START.getParam()).append('=').append(start).toString());
		return this;
	}
	
	public SolrQueryBuilder withFields(String... fieldList)
	{ 
		paramList.add(new StringBuilder().append(FL.getParam()).append('=').append(prepareFieldListParam(fieldList)).toString());
		return this;
	}

	public SolrQueryBuilder withResponseFormat(String wt)
	{ 
		paramList.add(new StringBuilder().append(WT.getParam()).append('=').append(wt).toString());
		return this;
	}
	
	private String prepareFieldListParam(String[] fieldList) {
		return Stream.of(fieldList).reduce("" , FieldConcatOperator::apply);
	}

	@Override
	public SolrQuery build() {
		return new SolrQuery(paramList.stream().reduce("", QueryStringConcatOperator::apply));
	}
	
	public static void main(String[] args)
	{ 
		SolrQueryBuilder qb = new SolrQueryBuilder();
		qb.withFields(new String[]{"sort,name,document"}).withParser("dismax").withQuery("where+is+sait+anger").withResponseFormat("json").withRows("100").withStart("100");
		System.out.println(qb.build().getSolrQuery());
	}

}
