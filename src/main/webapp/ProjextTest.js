/**
 * Created by lifengshuang on 6/19/15.
 */

window.ajax = function (url, data, info) {
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: url,
        data: data,
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
        token:"Hfyd7Nxcn",//token
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
