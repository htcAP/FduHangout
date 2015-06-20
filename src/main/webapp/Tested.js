/**
 * Created by lifengshuang on 6/20/15.
 */

var signature = function () {

    ajax(signaturetURL,
        {
            token: tokenList[10],
            signature: "我是童仲毅！！！"
        }, 'signature');
    request(function () {
        ajax(signaturetURL,
            {
                token: tokenList[17],
                signature: "测测测，不测不是人"
            }, 'signature');
    })
};

var getUser = function () {
    ajax(getUserURL,
        {
            token: tokenList[10],
            user_id: userIDList[3]
        }, 'u');
    request(function () {
        ajax(getUserURL,
            {
                token: tokenList[17],
                user_id: userIDList[7]
            }, 'u');
    })
};

var search = function () {

    request(function () {
        ajax(searchURL,
            {
                token: tokenList[0],
                search_text: '105'
            }, 'search 105');
        request(function () {
            ajax(searchURL,
                {
                    token: tokenList[1],
                    search_text: '101'
                }, 'search 101');
            request(function () {
                ajax(search_contactURL,
                    {
                        token: tokenList[0],
                        phones: ["15012341234", "15026849970", "15221920690", "3u7wu7dry3", '10000000145', "10000000194"]
                    }, 'search contact')
            })
        })
    })
};

var Friend = function () {
    window.request = function (func) {
        setTimeout(func, 5000);
    };

    ajax(addFriendURL,
        {
            token: tokenList[0],
            target_user: userIDList[0]
        },
        'add 00');

    request(function () {
        ajax(addFriendURL,
            {
                token: tokenList[0],
                target_user: userIDList[1]
            },
            'add 01');
        request(function () {
            ajax(addFriendURL,
                {
                    token: tokenList[1],
                    target_user: userIDList[0]
                },
                'add 10');
            request(function () {
                ajax(addFriendURL,
                    {
                        token: tokenList[0],
                        target_user: userIDList[2]
                    },
                    'add 02');
                request(function () {
                    ajax(acceptFriendURL,
                        {
                            token: tokenList[0],
                            target_user: userIDList[0]
                        },
                        'accept 00');
                    request(function () {
                        ajax(acceptFriendURL,
                            {
                                token: tokenList[2],
                                target_user: userIDList[0]
                            },
                            'accept 20');
                        request(function () {
                            ajax(acceptFriendURL,
                                {
                                    token: tokenList[2],
                                    target_user: userIDList[0]
                                },
                                'accept 20 again');
                            request(function () {
                                ajax(addFriendURL,
                                    {
                                        token: tokenList[0],
                                        target_user: userIDList[3]
                                    },
                                    'add 03');
                                request(function () {
                                    ajax(rejectFriendURL,
                                        {
                                            token: tokenList[3],
                                            target_user: userIDList[0]
                                        },
                                        'reject 30');
                                    request(function () {
                                        ajax(rejectFriendURL,
                                            {
                                                token: tokenList[3],
                                                target_user: userIDList[0]
                                            },
                                            'reject 30 again');
                                        request(function () {
                                            ajax(addFriendURL,
                                                {
                                                    token: tokenList[4],
                                                    target_user: userIDList[0]
                                                },
                                                'add 40');
                                            request(function () {
                                                ajax(addFriendURL,
                                                    {
                                                        token: tokenList[0],
                                                        target_user: userIDList[5]
                                                    },
                                                    'add 05');
                                                request(function () {
                                                    ajax(getFriendListURL,
                                                        {
                                                            token: tokenList[0]
                                                        },
                                                        'getFriendList 0');
                                                    request(function () {
                                                        ajax(getFriendListURL,
                                                            {
                                                                token: tokenList[3]
                                                            },
                                                            'getFriendList 0');
                                                    })
                                                })
                                            })
                                        })
                                    })
                                })
                            })
                        })
                    })
                })
            });
        });
    });
};

//var login = function () {
//    var i = 121;
//    var f = function () {
//        setTimeout(function () {
//            var user = {
//                phone: "10000000" + i,
//                password: "123456"
//                //username: "user" + i
//            };
//
//            $.ajax({
//                type: 'POST',
//                contentType: 'application/json',
//                url: '/fduhangout' + '/api/user/login/common',
//                data: JSON.stringify(user),
//                dataType: 'json',
//                success: function (d) {
//                    console.log(JSON.stringify(d));
//                    tokenList.push(d.token);
//                },
//                error: function () {
//                    console.log("error")
//                }
//            });
//
//            i++;
//            if (i < 150) {
//                f();
//            }
//        }, 3000);
//    };
//    return f;
//}();
//
//var register100 = function () {
//    for (var i = 100; i <= 110; i++){
//        var user = {
//            phone: "10000000" + i,
//            password: "123456"
//            //username: "user" + i
//        };
//        tokenList.push(user);
//
//        ajax(loginURL, user, "login:" + i)
//
//    }
//    console.log(JSON.stringify(tokenList));
//};
