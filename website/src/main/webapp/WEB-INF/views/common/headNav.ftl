<div class="sm-header">
    <div class="container" style="position: relative;">
        <div class="row">
            <ul class="nav navbar-nav navbar-right">
                <li role="presentation"><a href="/">首页</a></li>
                    <#if !logininfo??>
                <li role="presentation"><a href="/login.html">登录</a></li>
                <li role="presentation"><a href="/register.html">快速注册</a></li>
                    <#else>
                <li>
                    <a class="sm-current-user" href="/personal.do">${logininfo.username}</a>
                </li>
                <li><a  href="/recharge.do">账户充值</a></li>
                <li><a  href="/logout.do">注销 </a></li>
                    </#if>
                <li class="help-li"><a href="#">帮助</a></li>
            </ul>
        </div>
    </div>
</div>