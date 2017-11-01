<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;Charset=UTF-8">
    <title>个人中心</title>

    <#--引入框架插件相關文件-->
    <#include "common/link.ftl" />

    <#--引入css文件-->
    <link type="text/css" rel="stylesheet" href="/css/account.css">
    <#--引入的js文件-->
    <script type="text/javascript" src="/plugin/js/jquery.form.js"></script>

    <#--js-->
    <script type="text/javascript">
        $(function () {
        })
    </script>

</head>

<body>

<#--网页顶部导航栏-->
<!-- 包含一个模板文件,模板文件的路径是从当前路径开始找 -->
<#include "common/headNav.ftl"/>
<#--网页导航栏-->
<#assign currentNav="personal" />
<#include "common/nav.ftl" />

<div class="container">
    <div class="row">
        <!--导航菜单-->
        <div class="col-sm-3">
        <#assign currentMenu="personal" />
             <#--网页左侧导航栏-->
					<#include "common/leftMenu.ftl" />
        </div>
        <!-- 功能页面 -->
        <div class="col-sm-9" >
            <div class="panel panel-default sm-panel">
                <div class="panel-body sm-account">
                <#--个人信息-->
                    <div class="sm-account-info">
                        <div class="pull-left sm-head-img">
                            <img class="icon" src="/images/gaki2.jpg"/>
                        </div>
                        <div class="pull-left user-left">
                            <p>用户名：<span>${logininfo.username}</span></p>
                            <p>最后登录时间：<span>2017-10-25 00:43:22</span></p>
                        </div>
                        <div class="pull-left account-left"  style="text-align: center;width: 400px;margin:60px auto 0px auto;">
                            <a class="btn btn-primary btn-lg" href="/recharge.do">账户充值</a>
                            <a class="btn btn-danger btn-lg" href="/moneyWithdraw.do">账户提现</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>

                    <div class="row h4 account-info">
                        <div class="col-sm-4">
                            账户总额：<span class="text-primary">${account.totalAmount}元</span>
                        </div>
                        <div class="col-sm-4">
                            可用金额：<span class="text-primary">${account.usableAmount}元</span>
                        </div>
                        <div class="col-sm-4">
                            冻结金额：<span class="text-primary">${account.freezedAmount}元</span>
                        </div>
                    </div>

                    <div class="row h4 account-info">
                        <div class="col-sm-4">
                            待收利息：<span class="text-primary">${account.unReceiveInterest}元</span>
                        </div>
                        <div class="col-sm-4">
                            待收本金：<span class="text-primary">${account.unReceivePrincipal}元</span>
                        </div>
                        <div class="col-sm-4">
                            待还本息：<span class="text-primary">${account.unReturnAmount}元</span>
                        </div>
                    </div>

                <#--实名认证-->
                    <div class="sm-account-info top-margin">
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="sm-account-auth">
                                    <div class="sm-account-auth-left">
                                        <img src="images/shiming.png"/>
                                    </div>
                                    <div class="sm-account-auth-right">
                                        <h5>实名认证</h5>
                                    <#if userinfo.isRealAuth >
                                        <p>
                                            已认证
                                            <a href="#">查看</a>
                                        </p>
                                    <#else>
                                        <p>
                                            <#--未认证-->
                                            <a href="/realAuth.do" id="">立刻绑定</a>
                                        </p>
                                    </#if>
                                    </div>
                                    <div class="clearfix"></div>
                                    <p class="info">实名认证之后才能在平台投资</p>
                                </div>
                            </div>
                        <#--手机认证-->
                            <div class="col-sm-4">
                                <div class="sm-account-auth">
                                    <div class="sm-account-auth-left">
                                        <img src="images/shouji.jpg"/>
                                    </div>
                                    <div class="sm-account-auth-right">
                                        <h5>手机认证</h5>
                                    <#--<#if userinfo.isBindPhone >-->
                                        <p>
                                            已认证
                                            <a href="#">查看</a>
                                        </p>
                                    <#--<#else>-->
                                        <#--<p>-->
                                            <#--未认证-->
                                            <#--<a href="javascript:;" id="showBindPhoneModal">立刻绑定</a>-->
                                        <#--</p>-->
                                    <#--</#if>-->
                                    </div>
                                    <div class="clearfix"></div>
                                    <p class="info">可以收到系统操作信息,并增加使用安全性</p>
                                </div>
                            </div>
                        <#--邮箱认证-->
                            <div class="col-sm-4">
                                <div class="sm-account-auth">
                                    <div class="sm-account-auth-left">
                                        <img src="images/youxiang.jpg"/>
                                    </div>
                                    <div class="sm-account-auth-right">
                                        <h5>邮箱认证</h5>
                                    <#--<#if userinfo.isBindEmail>-->
                                        <p>
                                            已绑定
                                            <a href="#">查看</a>
                                        </p>
                                    <#--<#else>-->
                                        <#--<p>-->
                                            <#--未绑定-->
                                            <#--<a href="javascript:;" id="showBindEmailModal">去绑定</a>-->
                                        <#--</p>-->
                                    <#--</#if>-->
                                    </div>
                                    <div class="clearfix"></div>
                                    <p class="info">您可以设置邮箱来接收重要信息</p>
                                </div>
                            </div>
                        </div>
                    <#--VIP会员-->
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="sm-account-auth">
                                    <div class="sm-account-auth-left">
                                        <img src="images/baozhan.jpg"/>
                                    </div>
                                    <div class="sm-account-auth-right">
                                        <h5>VIP会员</h5>
                                        <p>
                                            普通用户
                                            <a href="#">查看</a>
                                        </p>
                                    </div>
                                    <div class="clearfix"></div>
                                    <p class="info">VIP会员，让你更快捷的投资</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="copy-rights" >
        <div class="bg bg-blur"></div>
        <p>Copyright &copy; 2017 Where you yourself are right,nothing that happens to you ever has wrong
            <a href="http://www.momo.com/" target="_blank" title="意趣">意趣</a> - Collect from <a href="http://www.momo.com/" title="意趣" target="_blank">意趣</a></p>
    </div>
</body>
</html>