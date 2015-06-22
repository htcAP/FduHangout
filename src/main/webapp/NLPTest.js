/**
 * Created by Tong on 06.22.
 */

var nlp_get_loction = function (raw_test) {
    var parseData = function (data) {
        var loc_matcher = data.match(/.+\[(.+?)\]LOC.+/i);
        if (loc_matcher) {
            return loc_matcher[1].replace(/[\s在]/g, '');
        } else {
            return "";
        }

    };

    var base = "http://ltpapi.voicecloud.cn/analysis/?";
    var api_key = "73S9E7p2mVGy8InA1vyzADktNjbr2JzBvdEweG1c";
    var pattern = 'srl';
    var text = raw_test;
    var format = "plain";
    var uri = (base
    + "api_key=" + api_key + "&text=" + text
    + "&pattern=" + pattern + "&format=" + format);
    $.ajax({
        type: "get",
        async: true,
        dataType: 'text/plain',
        url: uri
    }).always(function (data) {
        console.log(parseData(data.responseText));
    });

};

nlp_get_loction("我希望在下周一早上6点到8点15分在复旦或同济举行活动");