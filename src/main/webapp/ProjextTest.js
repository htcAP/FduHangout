/**
 * Created by lifengshuang on 6/19/15.
 */

window.ajax = function (url, data, info) {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: '/fduhangout' + url,
        data: JSON.stringify(data),
        dataType: 'json',
        success: function (d) {
            console.log(info + ": ");
            console.log(d);
            console.log(JSON.stringify(d));
            console.log('');
        },
        error: function () {
            console.log("error")
        }
    });
};

window.loginURL = '/api/user/login/common';
window.registerURL = '/api/user/register';
window.addFriendURL = '/api/user/friend/add';
window.removeFriendURL = '/api/user/friend/remove';
window.acceptFriendURL = '/api/user/friend/accept';
window.rejectFriendURL = '/api/user/friend/reject';
window.addActivityURL = '/api/activity/post/new';
window.inviteUserURL = '/api/activity/post/invite';
window.replyInviteURL = '/api/activity/post/reply_invite';
window.timeLocationURL = '/api/activity/post/time_location';
window.activityPhotoURL = '/api/activity/post/photo';
window.decideURL = '/api/activity//post/decide';
window.getActivityURL = '/api/activity/get/activity';
window.getAllActivityURL = '/api/activity/get/list/all';
window.getOngoingActivityURL = '/api/activity/get/list/ongoing';
window.getFinishedActivityURL = '/api/activity/get/list/finished';
window.getUserURL = '/api/user/get/user';
window.getFriendListURL = '/api/user/get/friend_list';
window.signaturetURL = '/api/user/signature';
window.searchURL = '/api/user/search';
window.search_contactURL = '/api/user/search_contact';
window.uploadImageURL = '/file/image';

function info() {
    console.log("Project Test:");
    console.log("100 user stored in localStorage ");
    console.log("");
}
info();

window.request = function (func) {
    setTimeout(func, 5000);
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

window.userList = JSON.parse('[{"phone":"10000000100","password":"123456"},{"phone":"10000000101","password":"123456"},{"phone":"10000000102","password":"123456"},{"phone":"10000000103","password":"123456"},{"phone":"10000000104","password":"123456"},{"phone":"10000000105","password":"123456"},{"phone":"10000000106","password":"123456"},{"phone":"10000000107","password":"123456"},{"phone":"10000000108","password":"123456"},{"phone":"10000000109","password":"123456"},{"phone":"10000000110","password":"123456"},{"phone":"10000000111","password":"123456"},{"phone":"10000000112","password":"123456"},{"phone":"10000000113","password":"123456"},{"phone":"10000000114","password":"123456"},{"phone":"10000000115","password":"123456"},{"phone":"10000000116","password":"123456"},{"phone":"10000000117","password":"123456"},{"phone":"10000000118","password":"123456"},{"phone":"10000000119","password":"123456"},{"phone":"10000000120","password":"123456"},{"phone":"10000000121","password":"123456"},{"phone":"10000000122","password":"123456"},{"phone":"10000000123","password":"123456"},{"phone":"10000000124","password":"123456"},{"phone":"10000000125","password":"123456"},{"phone":"10000000126","password":"123456"},{"phone":"10000000127","password":"123456"},{"phone":"10000000128","password":"123456"},{"phone":"10000000129","password":"123456"},{"phone":"10000000130","password":"123456"},{"phone":"10000000131","password":"123456"},{"phone":"10000000132","password":"123456"},{"phone":"10000000133","password":"123456"},{"phone":"10000000134","password":"123456"},{"phone":"10000000135","password":"123456"},{"phone":"10000000136","password":"123456"},{"phone":"10000000137","password":"123456"},{"phone":"10000000138","password":"123456"},{"phone":"10000000139","password":"123456"},{"phone":"10000000140","password":"123456"},{"phone":"10000000141","password":"123456"},{"phone":"10000000142","password":"123456"},{"phone":"10000000143","password":"123456"},{"phone":"10000000144","password":"123456"},{"phone":"10000000145","password":"123456"},{"phone":"10000000146","password":"123456"},{"phone":"10000000147","password":"123456"},{"phone":"10000000148","password":"123456"},{"phone":"10000000149","password":"123456"},{"phone":"10000000150","password":"123456"}]');
window.tokenList = JSON.parse('["562b55366596bbb90eb51730f913e187a43b59ce","14ebc7c52e1fd08168b99661cd9814b9fb38ee8c","9c2de57c7b0800b120b04e31066f96aafbf06276","36eea34f80289e2bc5f6f7f4344fe315af5ee879","9dbbfbb7367f82d286757b7302c34e8ebe62d38a","a30c4d6a65b229517675f95b8cec421c98ea78fa","784fe141875a78d760861e0b6c8ab8114b2ee0be","1cfda9ce3cbbc3ec6d2156723055abfadab42277","068299e56193e862099773012da5f5efcde83e91","4662baf5982db1018923f85a9ce8dbf23c7ce993","63138dd4ca42f91b049bfd64ffa5bdf7e4aaa451","c81136972947533f51628c525f664b59a65c6eb3","96b82a850399a7bccafc458bc1664173576337ff","547f473f8be031e1b7711a20e47241050de2e0a9","1df568955977a05cf2d222640b7b0c84377e3daf","089354df49d7db827cd3e74e3cebf7985137ea43","98746c764ea4ef0116f0bb41454bf47ed3a77bc2","912d63e65fc44a0c22e1587a46db2c7a6f629217","f2bab2e196e6b6447376dda8fe44a4bd08b75924","77c3c35902e9a8c48e7e00ff340312bd47552269","6d3b3f83918cea731c28fb049cea3bc094ecfa6e","0af756f552b4784d281f40d43a50c52a1b754a10","76dc0cdd02f398f00a022e28fccdaa87cea034df","19cc767f31a8d5d40bef3dfacbc961039e37f8dc","e2908fbb0beea3c9e965269fb68bab826def152e","7a1e83955336b40051fe28b41158799d17fd30d4","fbf66d28629c5eaf20ee6e9f37377ca901fe8e65","2d5f8879703588d058c15c6644fc4f6b3169ba66","39768fc1d4f001c79825fd48673d310d6bf1c955","37a93d893e6848ea96504e4744985481103b8fa3","bbb2ddc4bdacdd8e4e5915efd3b78e0d2bb6e3ea","421dbdf7fc0d3c1d42df584858e0cde4d86b66f5","3849345f84cc2c4e41411ee97dfa09b1b58851e6","4b8e8f19cbccfabc8443a5bee30ba57642744a50","c2b593b39ac3c28124cc07231c1e7409fc3b88c6","de6b64d10f279b765c73d63d00d92fda36d4f9e3","8ddf3d64112d92ec3c18f0fcec473336fb127a47","e7846a59253c5f87f4a0673a970d550b285e763c","ddae2c7c863f02e5af81388dc88d084149c7b130","d44cfca5ecf2554eff066c7db1c88887b66a7b31","28637013bfaa2ca29c263ec5e0b7c8c381b2b055","07d667d912930cf49edbb164e54e91c5fe91954d","cad4fc5e4e119f907dafa15c1ea4400af5d944c1","2938dd8fb0d270a1aa024609014e8182c098cca9","00fa2d1d13972f67ec83b9927fac1817520bd2f6","ba9742eb3f7edb8b914b7ea01cef2bb345ddecf5","2009a579ac4cdbd5f50a4e99e655bb1fb2660368","68bf39435424d0e070ee2019f88585c401085159","c2e022466bb7442eb5f419f6b385c3bbd48a307f","92f182b5d5d18eb6c145e21b5a5fe87ac4350897"]');
window.userIDList = [31, 29, 33, 32, 30, 28, 36, 34, 37, 35];





var model = function () {

//===============================login

    window.userLogin = {
        phone: "15012341234",
        password: "bbbbfe321"
    };
    window.loginURL = '/api/user/login/common';
    ajax(loginURL, JSON.stringify(userLogin), 'login');


//===============================register

    window.userRegister = {
        phone: "15012341234",
        password: "bbbbfe321",
        username: "lfs"
    };
    window.registerURL = '/api/user/register';
    ajax(registerURL, JSON.stringify(userRegister), 'register');


//===============================friend

    window.friend = {
        token: "fdsf",
        target_user: 233
    };
    window.addFriendURL = '/api/user/friend/add';
    ajax(addFriendURL, JSON.stringify(friend), 'add friend');

//===============================image

    window.image = {
        type: "png",
        data: "c7zwebr32BDSAxV67THGyguB6t5YgF36erDfgC2GH......."
    };
    window.imageURL = 'api/image/upload';
    ajax(imageURL, JSON.stringify(image), 'upload image');

//===============================activity

//=============add activity

    window.add_activity = {
        token: "Hfyd7Nxcn",//token
        title: "My Activity",
        description: "起来嗨!",
        deadline: "2011-10-05T14:48:00.000Z"//ISOString
    };
    window.addActivityURL = '/api/activity/post/new';
    ajax(addActivityURL, JSON.stringify(add_activity), 'add activity');

//=============invite

    var user_ids = [23, 4234, 5342, 52, 234, 3];

    window.invite_user = {
        token: "Hfyd7Nxcn",//token
        activity_id: 123,
        invites: user_ids//list of user_id
    };
    window.inviteUserURL = '/api/activity/post/invite';
    ajax(inviteUserURL, JSON.stringify(invite_user), 'invite user');

//=============reply invite

    window.replyInvite = {
        token: "Hfyd7Nxcn",//token
        activity_id: 123,
        attend: false
    };
    window.replyInviteURL = '/api/activity/post/reply_invite';
    ajax(replyInviteURL, JSON.stringify(replyInvite), 'reply invite');


//=============add time location

    window.time_location = {
        token: "Hfyd7Nxcn",//token
        time: {
            start_time: "2011-10-05T14:48:00.000Z",
            end_time: "2011-10-05T14:48:00.000Z"
        },
        location: {
            latitude: 123123.4324,
            longitude: 313213.4324,
            place: "Shanghai"
        },
        activity_id: 233
    };

    window.timeLocationURL = '/api/activity/post/time_location';
    ajax(timeLocationURL, JSON.stringify(time_location), "time location");
//    window

//=============add activity photo

    window.add_activity_photo = {
        token: "Hfyd7Nxcn",//token
        url: 'hahahaha.png',
        activity_id: 233
    };
    window.activityPhotoURL = '/api/activity/post/photo';
    ajax(activityPhotoURL, JSON.stringify(add_activity_photo), "add activity photo");

//==============decide activity

    window.decide = {
        token: "Hfyd7Nxcn",//token
        time_location_id: 213
    };
    window.decideURL = '/api/activity//post/decide';
    ajax(decideURL, JSON.stringify(decide), "decide");

//===============================get activity

//=============get activity
    window.getActivity = {
        token: "Hfyd7Nxcn",
        activity_id: 233
    };
    window.getActivityURL = '/api/activity/get/activity';
    ajax(getActivityURL, JSON.stringify(getActivity), "get activity");

//=============get all activity

    window.getAllActivity = {
        token: "Hfyd7Nxcn",
        activity_kind: 0
    };
    window.getAllActivityURL = '/api/activity/get/list/all';
    ajax(getAllActivityURL, JSON.stringify(getAllActivity), "get all activity");

//=============get ongoing activity

    window.getOngoingActivity = {
        token: "Hfyd7Nxcn",
        activity_kind: 1
    };
    window.getOngoingActivityURL = '/api/activity/get/list/ongoing';
    ajax(getOngoingActivityURL, JSON.stringify(getOngoingActivity), "get Ongoing activity");

//=============get finished activity

    window.getFinishedActivity = {
        token: "Hfyd7Nxcn",
        activity_kind: 2
    };
    window.getFinishedActivityURL = '/api/activity/get/list/finished';
    ajax(getFinishedActivityURL, JSON.stringify(getFinishedActivity), "get Finished activity");

//=================================get user information

    window.getUser = {
        token: "Hfyd7Nxcn",
        user_id: 1
    };
    window.getUserURL = '/api/user/get/user';
    ajax(getUserURL, JSON.stringify(getUser), "get user information");

//=================================get user friend list

    window.getFriendList = {
        token: "Hfyd7Nxcn"
    };
    window.getFriendListURL = '/api/user/get/friend_list';
    ajax(getFriendListURL, JSON.stringify(getFriendList), "get user friend list");

//=================================get user signature

    window.signature = {
        token: "Hfyd7Nxcn",
        signature: "fsdfds"
    };
    window.signaturetURL = '/api/user/signature';
    ajax(signaturetURL, JSON.stringify(signature), "set signature");

//=================================search user

    window.search = {
        token: "Hfyd7Nxcn",
        search_text: "fsdfds"
    };
    window.searchURL = '/api/user/search';
    ajax(searchURL, JSON.stringify(search), "search");


//=================================search contact

    window.search_contact = {
        token: "Hfyd7Nxcn",
        phones: ["15012341234", "27495729301", "13636663666"]
    };
    window.search_contactURL = '/api/user/search_contact';
    ajax(search_contactURL, JSON.stringify(search_contact), "search contact");

};
