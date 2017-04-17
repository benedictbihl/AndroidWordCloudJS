




function testSwap() {

    var textLoaded = window.android.loadText();
    var myConfig = {
        type: 'wordcloud',
        options: {
            text: "ada sffsf dfasdfg sdfgsdg sgsdv esdgvsdcf ",
            minLength: 4
        }
    };

    zingchart.render({
        id: 'myChart',
        data: myConfig,
        height: 400,
        width: '100%'
    });
    console.log(textLoaded)
}
