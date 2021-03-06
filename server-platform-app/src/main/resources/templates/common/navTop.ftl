<#import "../tags.ftl" as tags>
<#macro show>
<nav class="navbar navbar-static-top white-bg " role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <a class="navbar-minimalize minimalize-styl-2 btn btn-default " href="#"><i class="fa fa-bars"></i>
        </a>
    </div>

    <ul class="nav navbar-top-links navbar-right">
        <li>
            <span class="m-r-sm text-muted welcome-message">欢迎回来, <strong> <@tags.shiro.principal/></strong>!</span>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
            </a>
            <ul class="dropdown-menu dropdown-messages">
                <li>
                    <div class="dropdown-messages-box">
                        <a href="profile.html" class="pull-left">
                            <img alt="image" class="img-circle" src="/img/a7.jpg">
                        </a>

                        <div class="media-body">
                            <small class="pull-right">46h ago</small>
                            <strong>Mike Loreipsum</strong> started following <strong>Monica Smith</strong>.
                            <br>
                            <small class="text-muted">3 days ago at 7:58 pm - 10.06.2014</small>
                        </div>
                    </div>
                </li>
                <li class="divider"></li>
                <li>
                    <div class="dropdown-messages-box">
                        <a href="profile.html" class="pull-left">
                            <img alt="image" class="img-circle" src="/img/a4.jpg">
                        </a>

                        <div class="media-body">
                            <small class="pull-right text-navy">5h ago</small>
                            <strong>Chris Johnatan Overtunk</strong> started following <strong>Monica
                            Smith</strong>. <br>
                            <small class="text-muted">Yesterday 1:21 pm - 11.06.2014</small>
                        </div>
                    </div>
                </li>
                <li class="divider"></li>
                <li>
                    <div class="dropdown-messages-box">
                        <a href="profile.html" class="pull-left">
                            <img alt="image" class="img-circle" src="/img/profile.jpg">
                        </a>

                        <div class="media-body ">
                            <small class="pull-right">23h ago</small>
                            <strong>Monica Smith</strong> love <strong>Kim Smith</strong>. <br>
                            <small class="text-muted">2 days ago at 2:30 am - 11.06.2014</small>
                        </div>
                    </div>
                </li>
                <li class="divider"></li>
                <li>
                    <div class="text-center link-block">
                        <a href="mailbox.html">
                            <i class="fa fa-envelope"></i> <strong>Read All Messages</strong>
                        </a>
                    </div>
                </li>
            </ul>
        </li>
        <li class="dropdown">
            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
            </a>
            <ul class="dropdown-menu dropdown-alerts">
                <li>
                    <a href="mailbox.html">
                        <div>
                            <i class="fa fa-envelope fa-fw"></i> You have 16 messages
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="profile.html">
                        <div>
                            <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                            <span class="pull-right text-muted small">12 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <a href="grid_options.html">
                        <div>
                            <i class="fa fa-upload fa-fw"></i> Server Rebooted
                            <span class="pull-right text-muted small">4 minutes ago</span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li>
                    <div class="text-center link-block">
                        <a href="notifications.html">
                            <strong>See All Alerts</strong>
                            <i class="fa fa-angle-right"></i>
                        </a>
                    </div>
                </li>
            </ul>
        </li>
        <li>
            <a href="/logout">
                <i class="fa fa-sign-out"></i> Log out
            </a>
        </li>
        <@tags.shiro.hasRole role="restaurant">
            <li>
                <a class="right-sidebar-toggle">
                    <i class="fa fa-tasks"></i>
                </a>
            </li>
        </@tags.shiro.hasRole>
    </ul>
    <@tags.shiro.hasRole role="restaurant">
        <div id="right-sidebar"">
            <div class="sidebar-container">
                <div class="sidebar-title">
                    <h3><i class="fa fa-gears"></i> 设置</h3>
                    <small><i class="fa fa-tim"></i> 您的店铺已经线上运营105天!</small>
                </div>

                <div class="setings-item">
                    <h4>
                        店铺线上营业状态
                    </h4>
                    <p class="text-danger">
                        <small>如需进行店铺整顿，请将店铺状态调整为歇业，以免造成不必要的损失!</small>
                    </p>
                    <span id="online-open-status-text">
                        ${Session['session_key_restaurant'].opening?string('火爆营业中', '线上整顿中')}
                    </span>
                    <div class="switch" data-toggle="tooltip" title="改变店铺线上营业状态">
                        <div class="onoffswitch">
                            <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox"
                                   id="online-open-status-switch" <#if Session['session_key_restaurant'].opening>checked</#if>>
                            <label class="onoffswitch-label" for="online-open-status-switch">
                                <span class="onoffswitch-inner"></span>
                                <span class="onoffswitch-switch"></span>
                            </label>
                        </div>
                    </div>
                </div>


                <div class="sidebar-content">
                    <h4>永恒寄语</h4>
                    <div class="small">
                        <i class="fa fa-smile-o"></i> 不想当将军的士兵不是好士兵.
                    </div>
                </div>
            </div>
        </div>
    </@tags.shiro.hasRole>
</nav>
<nav class="wrapper message bg-warning border-bottom">
    <strong>公告: </strong><a href="#" class="text-white"><span class="content">关于赶紧续费不然停机的通知!</span></a>
    <button class="btn btn-xs btn-default pull-right">隐藏</button>
</nav>
</#macro>