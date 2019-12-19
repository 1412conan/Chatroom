//=======================================================================
//author: shihuc
//date: 2018-09-19
//动态获取服务地址
//=======================================================================
var protocol = window.location.protocol;
var baseService = window.location.host;
var pathName = window.location.pathname;
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

var protocolStr = document.location.protocol;
var baseHttpProtocol = "http://";
if (protocolStr == "https:") {
    baseHttpProtocol = "https://";
}
var svrUrl = baseHttpProtocol + baseService + projectName + "/audio/trans";
//=========================================================================

var recorder = null;
var startButton = document.getElementById('btn-start-recording');
var stopButton = document.getElementById('btn-stop-recording');
var playButton = document.getElementById('btn-start-palying');

//var audio = document.querySelector('audio');
var audio = document.getElementById('audioSave');

function startRecording() {
    if (recorder != null) {
        recorder.close();
    }
    Recorder.get(function (rec) {
        recorder = rec;
        recorder.start();
    });
    stopButton.disabled = false;
    playButton.disabled = false;
}

function stopRecording() {
    recorder.stop();
    recorder.trans(svrUrl, function (res, errcode) {
        if (errcode != 500) {
            alert(res);
        }
    });
}

function playRecording() {
    recorder.play(audio);
}