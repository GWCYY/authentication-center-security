package com.fx.authentication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "oauth_client_details", schema = "authentication")
public class OauthClientDetails implements Serializable {

    private static final long serialVersionUID = 2399772943196115325L;

    @Id
    @GeneratedValue(generator = "snowFlakeId")
    @GenericGenerator(name = "snowFlakeId", strategy = "com.fx.authentication.entity.SnowFlakeIdGenerator")
    @Column(name = "id")
    private Long id;

    /**
     * 客户端ID
     */
    @Column(name = "client_id", columnDefinition = "")
    private String clientId;

    /**
     * 客户端所能访问的资源id集合，多个资源时用逗号(,)分隔
     */
    @Column(name = "resource_ids")
    private String resourceIds;

    /**
     * 客户端访问密匙
     */
    @Column(name = "client_secret")
    private String clientSecret;

    /**
     * 客户端申请的权限范围，可选值包括read,write,trust;若有多个权限范围用逗号(,)分隔
     */
    @Column(name = "scope")
    private String scope;

    /**
     * 客户端支持的授权许可类型(grant_type)，可选值包括authorization_code,password,
     * refresh_token,implicit,client_credentials,若支持多个授权许可类型用逗号(,)分隔
     */
    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;

    /**
     * 客户端重定向URI，当grant_type为authorization_code或implicit时, 在Oauth的流程中会使用并检查与数据库内的redirect_uri是否一致
     */
    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;

    /**
     * 客户端所拥有的Spring Security的权限值,可选, 若有多个权限值,用逗号(,)分隔
     */
    @Column(name = "authorities")
    private String authorities;

    /**
     * 设定客户端的access_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时)
     */
    @Column(name = "access_token_validity")
    private Long accessTokenValidity;

    /**
     * 设定客户端的refresh_token的有效时间值(单位:秒)，若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天)
     */
    @Column(name = "refresh_token_validity")
    private Long refreshTokenValidity;

    /**
     * 这是一个预留的字段,在Oauth的流程中没有实际的使用,可选,但若设置值,必须是JSON格式的数据
     */
    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "create_time")
    private Long createTime;

    /**
     * 设置用户是否自动批准授予权限操作, 默认值为 'false’, 可选值包括 'true’,'false’, 'read’,'write’.
     */
    @Column(name = "autoapprove")
    private String autoapprove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Long getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Long accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Long getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Long refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}
