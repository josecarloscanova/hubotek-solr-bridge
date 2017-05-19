package org.hubotek.solr.client.query;

import static org.hubotek.solr.client.query.SolrQueryCommonEnum.DEFTYPE;

import java.util.stream.Stream;

import org.hubotek.Builder;
import org.hubotek.solr.util.FieldConcatOperator;

public class SolrQueryBuilder implements Builder<SolrQueryBase>{

	
	
	public SolrQueryBuilder() {
	}

	public SolrQueryBuilder withParser(String queryParser)
	{ 
		new StringBuilder().append(DEFTYPE.getParam()).append(queryParser);
		return this;
	}
	
	public SolrQueryBuilder withFields(String... fieldList)
	{ 
		prepareFieldListParam(fieldList);
		return this;
	}
	
	private String prepareFieldListParam(String[] fieldList) {
		return Stream.of(fieldList).reduce("" , FieldConcatOperator::apply);
	}

	@Override
	public SolrQueryBase build() {
		return new SolrQueryBase();
	}
	
	public static void main(String[] args)
	{ 
		SolrQueryBuilder qb = new SolrQueryBuilder();
		System.out.println(qb.prepareFieldListParam(new String[]{"1" , "2" , "3"}));
	}

}
