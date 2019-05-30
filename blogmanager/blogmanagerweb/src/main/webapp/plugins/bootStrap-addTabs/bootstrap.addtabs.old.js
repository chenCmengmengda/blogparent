/**
 * Website: http://git.oschina.net/hbbcs/bootStrap-addTabs
 *
 * Version : 1.7
 *
 * Created by joe on 2016-2-4.Update 2017-02-15
 */

$.fn.addtabs = function (options) {

    Addtabs.options = $.extend({
        content: '', //直接指定所有页面TABS内容
        close: true, //是否可以关闭
        monitor: 'body', //监视的区域
        iframeUse: true, //使用iframe还是ajax
        iframeHeight: $(document).height() - 107, //固定TAB中IFRAME高度,根据需要自己修改
        contextmenu: true,//是否使用右键菜单
        obj: this,
        local: {
            'refreshLabel': '刷新此标签',
            'closeThisLabel': '关闭此标签',
            'closeOtherLabel': '关闭其他标签',
            'closeLeftLabel': '关闭左侧标签',
            'closeRightLabel': '关闭右侧标签'
        },
        callback: function () { //关闭后回调函数
        }
    }, options || {});

console.log(Addtabs.options);
    $(Addtabs.options.monitor).on('click', '[data-addtab]', function () {
        Addtabs.add({
            id: $(this).data('addtab'),
            title: $(this).data('title') ? $(this).data('title') : $(this).html(),
            content: Addtabs.options.content ? Addtabs.options.content : $(this).data('content'),
            url: $(this).data('url'),
            ajax: $(this).data('ajax') ? true : false
        });
    });

    Addtabs.options.obj.on('click', '.close-tab', function () {
        var id = $(this).prev("a").attr("aria-controls");
        Addtabs.close(id);
    });

    if (Addtabs.options.contextmenu) {
        //obj上禁用右键菜单
        Addtabs.options.obj.on('contextmenu', 'li[role=presentation]', function () {
            var id = $(this).children('a').attr('aria-controls');
            Addtabs.pop(id, $(this));
            return false;
        });

        //刷新页面
        Addtabs.options.obj.on('click', 'ul.rightMenu a[data-right=refresh]', function () {
            var id = $(this).parent('ul').attr("aria-controls").substring(4);
            var url = $(this).parent('ul').attr('aria-url');
            Addtabs.add({'id': id, 'url': url, 'refresh': true});
        });

        //关闭自身
        Addtabs.options.obj.on('click', 'ul.rightMenu a[data-right=remove]', function () {
            var id = $(this).parent("ul").attr("aria-controls");
            if (id.substring(0, 4) != 'tab_') return;
            Addtabs.close(id);
            Addtabs.drop();
        });

        //关闭其他
        Addtabs.options.obj.on('click', 'ul.rightMenu a[data-right=remove-circle]', function () {
            var tab_id = $(this).parent('ul').attr("aria-controls");
            Addtabs.options.obj.children('ul.nav').find('li').each(function () {
                var id = $(this).attr('id');
                if (id && id != 'tab_' + tab_id) {
                    Addtabs.close($(this).children('a').attr('aria-controls'));
                }
            });
            Addtabs.drop();
        });

        //关闭左侧
        Addtabs.options.obj.on('click', 'ul.rightMenu a[data-right=remove-left]', function () {
            var tab_id = $(this).parent('ul').attr("aria-controls");
            $('#tab_' + tab_id).prevUntil().each(function () {
                var id = $(this).attr('id');
                if (id && id != 'tab_' + tab_id) {
                    Addtabs.close($(this).children('a').attr('aria-controls'));
                }
            });
            Addtabs.drop();
        });

        //关闭右侧
        Addtabs.options.obj.on('click', 'ul.rightMenu a[data-right=remove-right]', function () {
            var tab_id = $(this).parent('ul').attr("aria-controls");
            $('#tab_' + tab_id).nextUntil().each(function () {
                var id = $(this).attr('id');
                if (id && id != 'tab_' + tab_id) {
                    Addtabs.close($(this).children('a').attr('aria-controls'));
                }
            });
            Addtabs.drop();
        });
    }

    //拖动
    var el;
    Addtabs.options.obj.on('dragstart.h5s', 'li', function (e) {
        el = $(this);
    }).on('dragover.h5s dragenter.h5s drop.h5s', 'li', function (e) {
        if (el == $(this)) return;
        $('.dragBack').removeClass('dragBack');
        $(this).addClass('dragBack');
        el.insertAfter($(this))
    }).on('dragend.h5s', 'li', function () {
        $('.dragBack').removeClass('dragBack');
    });

    if (Addtabs.options.close) {
        Addtabs.options.obj.on('mouseover', 'li[role = "presentation"]', function () {
            $(this).find('.close-tab').show();
        });

        Addtabs.options.obj.on('mouseleave', 'li[role = "presentation"]', function () {
            $(this).find('.close-tab').hide();
        });
    }

    $(window).resize(function () {
        Addtabs.options.obj.find('iframe').attr('height', Addtabs.options.iframeHeight);
        Addtabs.drop();
    });

};

window.Addtabs = {
    options: {},
    add: function (opts) {
        var id = 'tab_' + opts.id;
        Addtabs.options.obj.find('li[role = "presentation"].active').removeClass('active');
        Addtabs.options.obj.find('div[role = "tabpanel"].active').removeClass('active');
        //如果TAB不存在，创建一个新的TAB
        if (Addtabs.options.obj.find("#" + id).length<=0) {
            //创建新TAB的title
            var title = $('<li>', {
                'role': 'presentation',
                'id': 'tab_' + id,
                'aria-url': opts.url
            }).append(
                $('<a>', {
                    'href': '#' + id,
                    'aria-controls': id,
                    'role': 'tab',
                    'data-toggle': 'tab'
                }).html(opts.title)
            );

            //是否允许关闭
            if (Addtabs.options.close) {
                title.append(
                    $('<i>', {'class': 'close-tab glyphicon glyphicon-remove'})
                );
            }
            //创建新TAB的内容
            var content = $('<div>', {
                'class': 'tab-pane',
                'id': id,
                'role': 'tabpanel'
            });

            //加入TABS
            Addtabs.options.obj.children('.nav-tabs').append(title);
            Addtabs.options.obj.children(".tab-content").append(content);
        } else if (!opts.refresh) {
            $('#tab_' + id).addClass('active');
            $('#' + id).addClass('active');
            Addtabs.drop();
            return;
        } else {
            var content = $('#' + id);
            content.html('');
        }

        //是否指定TAB内容
        if (opts.content) {
            content.append(opts.content);
        } else if (Addtabs.options.iframeUse && !opts.ajax) {//没有内容，使用IFRAME打开链接
            content.append(
                $('<iframe>', {
                    'class': 'iframeClass',
                    'height': Addtabs.options.iframeHeight,
                    'frameborder': "no",
                    'border': "0",
                    'src': opts.url
                })
            );
        } else {
            $.get(opts.url, function (data) {
                content.append(data);
            });
        }

        //激活TAB
        $('#tab_' + id).addClass('active');
        $('#' + id).addClass('active');
        Addtabs.drop();
    },
    createMenu: function (right, icon, text) {
        return $('<a>', {
            'href': 'javascript:void(0);',
            'class': "list-group-item",
            'data-right': right
        }).append(
            $('<i>', {'class': 'glyphicon ' + icon})
        ).append(text);
    },
    pop: function (id, e) {
        $('body').find('#popMenu').remove();
        var refresh = e.attr('id') ? Addtabs.createMenu('refresh', 'glyphicon-refresh', Addtabs.options.local.refreshLabel) : '';
        var remove = e.attr('id') ? Addtabs.createMenu('remove', 'glyphicon-remove', Addtabs.options.local.closeThisLabel) : '';
        var left = e.prev('li').attr('id') ? Addtabs.createMenu('remove-left', 'glyphicon-chevron-left', Addtabs.options.local.closeLeftLabel) : '';
        var right = e.next('li').attr('id') ? Addtabs.createMenu('remove-right', 'glyphicon-chevron-right', Addtabs.options.local.closeRightLabel) : '';
        var popHtml = $('<ul>', {
            'aria-controls': id,
            'class': 'rightMenu list-group',
            id: 'popMenu',
            'aria-url': e.attr('aria-url')
        }).append(refresh)
            .append(remove)
            .append(Addtabs.createMenu('remove-circle', 'glyphicon-remove-circle', Addtabs.options.local.closeOtherLabel))
            .append(left)
            .append(right);
        popHtml.css({
            'top': e[0].offsetTop + 10,
            'left': e[0].offsetLeft + 60
        });
        popHtml.appendTo(Addtabs.options.obj).fadeIn('slow');
        popHtml.mouseleave(function () {
            $(this).fadeOut('slow');
        });
        $('body').click(function () {
            popHtml.fadeOut('slow');
        })
    },
    close: function (id) {
        //如果关闭的是当前激活的TAB，激活他的前一个TAB
        if (Addtabs.options.obj.find("li.active").attr('id') === "tab_" + id) {
            $("#tab_" + id).prev().addClass('active');
            $("#" + id).prev().addClass('active');
        }
        //关闭TAB
        $("#tab_" + id).remove();
        $("#" + id).remove();
        Addtabs.drop();
        Addtabs.options.callback();
    },
    closeAll: function () {
        $.each(Addtabs.options.obj.find('li[id]'), function () {
            var id = $(this).children('a').attr('aria-controls');
            $("#tab_" + id).remove();
            $("#" + id).remove();
        });
        Addtabs.options.obj.find('li[role = "presentation"]').first().addClass('active');
        var firstID = Addtabs.options.obj.find('li[role = "presentation"]').first().children('a').attr('aria-controls');
        $('#' + firstID).addClass('active');
        Addtabs.drop();
    },
    drop: function () {
        element = Addtabs.options.obj.find('.nav-tabs');
        //创建下拉标签
        var dropdown = $('<li>', {
            'class': 'dropdown pull-right hide tabdrop tab-drop'
        }).append(
            $('<a>', {
                'class': 'dropdown-toggle',
                'data-toggle': 'dropdown',
                'href': '#'
            }).append(
                $('<i>', {'class': "glyphicon glyphicon-align-justify"})
            ).append(
                $('<b>', {'class': 'caret'})
            )
        ).append(
            $('<ul>', {'class': "dropdown-menu"})
        )

        //检测是否已增加
        if (!$('.tabdrop').html()) {
            dropdown.prependTo(element);
        } else {
            dropdown = element.find('.tabdrop');
        }
        //检测是否有下拉样式
        if (element.parent().is('.tabs-below')) {
            dropdown.addClass('dropup');
        }
        var collection = 0;

        //检查超过一行的标签页
        element.append(dropdown.find('li'))
            .find('>li')
            .not('.tabdrop')
            .each(function () {
                if (this.offsetTop > 0 || element.width() - $(this).position().left - $(this).width() < 83) {
                    dropdown.find('ul').prepend($(this));
                    collection++;
                }
            });

        //如果有超出的，显示下拉标签
        if (collection > 0) {
            dropdown.removeClass('hide');
            if (dropdown.find('.active').length == 1) {
                dropdown.addClass('active');
            } else {
                dropdown.removeClass('active');
            }
        } else {
            dropdown.addClass('hide');
        }
    }
}
