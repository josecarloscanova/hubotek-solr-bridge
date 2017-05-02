package org.hubotek.solr.configuration.rdb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="solr_configuration_settings")
public class SolrConfigurationSettings extends ConfigurationBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3275315093190807192L;

	@Column(name="max_retries")
	private Integer maxRetries;
	
	@Column(name="connection_timeout")
	private Integer connectionTimeout; 
	
	@Column(name="socket_timeout")
	private Integer soTimeout;
	
	@Column(name="default_max_host_connection")
	private Integer defaultMaxConnectionsPerHost; 	
	
	@Column(name="max_total_connections")
	private Integer maxTotalConnections;
	
	@Column(name="follow_redirects")
	private Boolean followRedirects;
	
	
	public SolrConfigurationSettings() {
	}


	public Integer getMaxRetries() {
		return maxRetries;
	}


	public void setMaxRetries(Integer maxRetries) {
		this.maxRetries = maxRetries;
	}


	public Integer getConnectionTimeout() {
		return connectionTimeout;
	}


	public void setConnectionTimeout(Integer connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}


	public Integer getSoTimeout() {
		return soTimeout;
	}


	public void setSoTimeout(Integer soTimeout) {
		this.soTimeout = soTimeout;
	}


	public Integer getDefaultMaxConnectionsPerHost() {
		return defaultMaxConnectionsPerHost;
	}


	public void setDefaultMaxConnectionsPerHost(Integer defaultMaxConnectionsPerHost) {
		this.defaultMaxConnectionsPerHost = defaultMaxConnectionsPerHost;
	}


	public Integer getMaxTotalConnections() {
		return maxTotalConnections;
	}


	public void setMaxTotalConnections(Integer maxTotalConnections) {
		this.maxTotalConnections = maxTotalConnections;
	}


	public Boolean getFollowRedirects() {
		return followRedirects;
	}


	public void setFollowRedirects(Boolean followRedirects) {
		this.followRedirects = followRedirects;
	}

}
