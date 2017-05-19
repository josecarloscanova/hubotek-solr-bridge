package org.hubotek.solr.client.query;

/**
 * Header is big to extract some features for abstraction on query parameters for the component.
 * 
 * The defType Parameter
The defType parameter selects the query parser that Solr should use to process the main query parameter (q) in the request. For example:
defType=dismax
If no defType param is specified, then by default, the The Standard Query Parser is used.  (eg: defType=lucene)

The start Parameter
When specified, the start parameter specifies an offset into a query's result set and instructs Solr to begin displaying results from this offset.
The default value is "0". In other words, by default, Solr returns results without an offset, beginning where the results themselves begin.
Setting the start parameter to some other number, such as 3, causes Solr to skip over the preceding records and start at the document identified by the offset.
You can use the start parameter this way for paging. 
For example, if the rows parameter is set to 10, you could display three successive pages of results by setting start to 0, then re-issuing 
the same query and setting start to 10, then issuing the query again and setting start to 20.

A sort ordering must include a field name (or score as a pseudo field), followed by whitespace (escaped as + or %20 in URL strings), followed by a sort direction (asc or desc).
Multiple sort orderings can be separated by a comma, using this syntax: sort=<field name>+<direction>,<field name>+<direction>],...
When more than one sort criteria is provided, the second entry will only be used if the first entry results in a tie. If there is a third entry, it will only be used if the first AND second entries are tied. 
This pattern continues with further entries.

"sort format is sort:<field>+direction = using the %20 http parameter to 

 * Stores the common query terms that allow add the parameters based on a 
 * expression contructed prior of query execution.
 * 
 * 
 * The start Parameter
When specified, the start parameter specifies an offset into a query's result set and instructs Solr to begin displaying results from this offset.
The default value is "0". In other words, by default, Solr returns results without an offset, beginning where the results themselves begin.
Setting the start parameter to some other number, such as 3, causes Solr to skip over the preceding records and start at the document identified by the offset.
You can use the start parameter this way for paging. For example, if the rows parameter is set to 10, you could display three successive pages of results by setting start to 0, then re-issuing the same query and setting start to 10, then issuing the query again and setting start to 20.

The rows Parameter
You can use the rows parameter to paginate results from a query. The parameter specifies the maximum number of documents from the complete result set that Solr should return to the client at one time.
The default value is 10. That is, by default, Solr returns 10 documents at a time in response to a query.

The fq (Filter Query) Parameter
The fq parameter defines a query that can be used to restrict the superset of documents that can be returned, without influencing score. It can be very useful for speeding up complex queries, since the queries specified with fq are cached independently of the main query. When a later query uses the same filter, there's a cache hit, and filter results are returned quickly from the cache.
When using the fq parameter, keep in mind the following:
The fq parameter can be specified multiple times in a query. Documents will only be included in the result if they are in the intersection of the document sets resulting from each instance of the parameter. In the example below, only documents which have a popularity greater then 10 and have a section of 0 will match.
fq=popularity:[10 TO *]&fq=section:0
Filter queries can involve complicated Boolean queries. The above example could also be written as a single fq with two mandatory clauses like so:
fq=+popularity:[10 TO *] +section:0
The document sets from each filter query are cached independently. Thus, concerning the previous examples: use a single fq containing two mandatory clauses if those clauses appear together often, and use two separate fq parameters if they are relatively independent. (To learn about tuning cache sizes and making sure a filter cache actually exists, see The Well-Configured Solr Instance.)
It is also possible to use filter(condition) syntax inside the fq to cache clauses individually and - among other things - to achieve union of cached filter queries.
As with all parameters: special characters in an URL need to be properly escaped and encoded as hex values. Online tools are available to help you with URL-encoding. For example: http://meyerweb.com/eric/tools/dencoder/.

The fl (Field List) Parameter
The fl parameter limits the information included in a query response to a specified list of fields. The fields need to either be stored="true" or  docValues="true".
The field list can be specified as a space-separated or comma-separated list of field names. The string "score" can be used to indicate that the score of each document for the particular query should be returned as a field. The wildcard character "*" selects all the fields in the document which are either stored="true" or  docValues="true" and useDocValuesAsStored="true" (which is the default when docValues are enabled). You can also add pseudo-fields, functions and transformers to the field list request.
This table shows some basic examples of how to use fl:
Field List
Result
id name price
Return only the id, name, and price fields.
id,name,price
Return only the id, name, and price fields.
id name, price
Return only the id, name, and price fields.
id score
Return the id field and the score.
*
Return all the stored fields in each document, as well as any docValues fields that have useDocValuesAsStored="true". This is the default value of the fl parameter.
* score
Return all the fields in each document, along with each field's score.
*,dv_field_name	Return all the stored fields in each document, and any docValues fields that have useDocValuesAsStored="true" and the docValues from dv_field_name even if it has useDocValuesAsStored="false"
Function Values
Functions can be computed for each document in the result and returned as a pseudo-field:
fl=id,title,product(price,popularity)
Document Transformers
Document Transformers can be used to modify the information returned about each documents in the results of a query:
fl=id,title,[explain]
Field Name Aliases
You can change the key used to in the response for a field, function, or transformer by prefixing it with a "displayName:". For example:
fl=id,sales_price:price,secret_sauce:prod(price,popularity),why_score:[explain style=nl]
  "response":{"numFound":2,"start":0,"docs":[
      {
        "id":"6H500F0",
        "secret_sauce":2100.0,
        "sales_price":350.0,
        "why_score":{
          "match":true,
          "value":1.052226,
          "description":"weight(features:cache in 2) [DefaultSimilarity], result of:",
          "details":[{
...

 * 
 * @author JoseCanova
 *
 */
public enum SolrQueryCommonEnum {

	DEFTYPE("defType"),
	SORT("sort"),
	START("start"),
	ROWS("rows"),
	FQ("fq"), 
	FL("fl"),
	DEBUG("debug"), 
	EXPLAINOTHER("explainOther"),
	TIMEALLOWED("timeAllowed"),
	SEGGMENTTERMINATEEARY("segmentTerminateEarly"),
	OMITHEADER("omitHeader"),
	WT("wt"),
	LOGPARAMSLIST("logParamsList"),
	ECHOPARAMS("echoParams"),
	QUERY("q");
	
	private String param;
	
	private SolrQueryCommonEnum(String val)
	{ 
		this.param = val;
	}
	
	public String getParam()
	{ 
		return param;
	}
}
