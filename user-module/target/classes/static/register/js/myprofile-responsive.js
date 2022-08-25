function initResizeListener() {
    var listener = new ResizeListener();
    // call change method for initial load case
    listener._handleChange(listener._matchMediaQueryList);
}

function ResizeListener() {
    this._matchMediaQueryList = 
          window.matchMedia("screen and (max-width:768px)");
    this._matchMediaQueryList.addListener(this._handleChange);
}

AdfObject.createSubclass(ResizeListener, AdfObject);

ResizeListener.prototype._handleChange = function (_matchMediaQueryList) {
    callSetScreenSize();
}

function callSetScreenSize() {
 var w = window,
    d = document,
    e = d.documentElement,
    g = d.getElementsByTagName('body')[0],
    width = w.innerWidth || e.clientWidth || g.clientWidth,
    height = w.innerHeight|| e.clientHeight|| g.clientHeight;
    var ratio = window.devicePixelRatio; 
    
    var adfDocument = AdfPage.PAGE.findComponentByAbsoluteId('docCreate');
    var isPartial = true;
    var customEvent =  new AdfCustomEvent(adfDocument, "setScreenSize", 
        {
          'screenWidth' : width, 'screenHeight' : height
          , 'devicePixelRatio' : ratio
        },true);
    
   customEvent.preventUserInput();
   customEvent.queue(isPartial); 
}

function showWindowSize()
{
   var w = window,
    d = document,
    e = d.documentElement,
    g = d.getElementsByTagName('body')[0],
    width = w.innerWidth || e.clientWidth || g.clientWidth,
    height = w.innerHeight|| e.clientHeight|| g.clientHeight;
    alert ("width: "+width+", height: "+height);
}