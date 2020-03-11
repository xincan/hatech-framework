<template>
  <div id="api">
    <el-scrollbar style="height: 100%">
      <div id="main">
        <div class="sidebar">
          <el-scrollbar style="height: 100%">
            <div class="sidebar-inner">
              <h3>
                <a  style="color:#8b9fb5" href="#Gdraw-api">Gdraw</a>
              </h3>
              <ol>
                <li>
                  <a href="#Gdrawversion" class="primary">version</a>
                </li>
                <li>
                  <a href="#Gdrawdisposezr" class="primary">dispose()</a>
                </li>
                <li>
                  <a href="#addel">add()</a>
                </li>
                <li>
                  <a href="#addhoverel-style">addHover()</a>
                </li>
                <li>
                  <a href="#animation">animation</a>
                </li>
                <li>
                  <a href="#clear">clear()</a>
                </li>
                <li>
                  <a href="#clearanimation">clearAnimation()</a>
                </li>
                <li>
                  <a href="#clearhover">clearHover()</a>
                </li>
                <li>
                  <a href="#configlayerzlevel-config">configLayer()</a>
                </li>
                <li>
                  <a href="#dispose">dispose()</a>
                </li>
                <li>
                  <a href="#dom">dom</a>
                </li>
                <li>
                  <a href="#find">find()</a>
                </li>
                <li>
                  <a href="#flush">flush()</a>
                </li>
                <li>
                  <a href="#getheight">getHeight()</a>
                </li>
                <li>
                  <a href="#getwidth">getWidth()</a>
                </li>
                <li>
                  <a href="#getDataURL">getDataURL()</a>
                </li>
                <li>
                  <a href="#id">id</a>
                </li>
                <li>
                  <a href="#offeventname-eventhandler">off()</a>
                </li>
                <li>
                  <a href="#oneventname-eventhandler-context">on()</a>
                </li>
                <li>
                  <a href="#refresh">refresh()</a>
                </li>
                <li>
                  <a href="#refreshhover">refreshHover()</a>
                </li>
                <li>
                  <a href="#refreshhoverimmediately">refreshHoverImmediately()</a>
                </li>
                <li>
                  <a href="#refreshimmediately">refreshImmediately()</a>
                </li>
                <li>
                  <a href="#removeel">remove()</a>
                </li>
                <li>
                  <a href="#removehoverel">removeHover()</a>
                </li>
                <li>
                  <a href="#resizeopts">resize()</a>
                </li>
                <li>
                  <a href="#savePicture">savePicture()</a>
                </li>
                <li>
                  <a href="#triggereventname-event">trigger()</a>
                </li>
              </ol>
              <ol>
                <li>
                  <a href="#Gdrawanimatable" class="primary">.Animatable</a>
                  <ol>
                    <li>
                      <a href="#Gdrawanimatableanimatepath-loop">animate()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatableanimatetotarget-time-delay-easing-callback-forceanimate">animateTo()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatablestopanimationforwardtolast">stopAnimation()</a>
                    </li>
                  </ol>
                  <a href="#Gdrawanimator" class="primary">.Animator</a>
                  <ol>
                    <li>
                      <a href="#Gdrawanimatordelaytime">delay()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatordonecallback">done()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatorduringcallback">during()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatorispaused">isPaused()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatorpause">pause()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatorresume">resume()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatorstarteasing">start()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatorstopforwardtolast">stop()</a>
                    </li>
                    <li>
                      <a href="#Gdrawanimatorwhentime-props">when()</a>
                    </li>
                  </ol>
                  <a href="#Gdrawboundingrect" class="primary">.BoundingRect</a>
                  <ol>
                    <li>
                      <a href="#Gdrawboundingrectclone">clone()</a>
                    </li>
                    <li>
                      <a href="#Gdrawboundingrectcontainx-y">contain()</a>
                    </li>
                    <li>
                      <a href="#Gdrawboundingrectcopyother">copy()</a>
                    </li>
                    <li>
                      <a href="#Gdrawboundingrectintersectother">intersect()</a>
                    </li>
                    <li>
                      <a href="#Gdrawboundingrectunionother">union()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdrawcolor" class="primary">.color</a>
                  <ol>
                    <li>
                      <a href="#Gdrawcolorliftcolor-level">lift()</a>
                    </li>
                    <li>
                      <a href="#Gdrawcolormaptocolornormalizedvalue-colors-fulloutput">mapToColor()</a>
                    </li>
                    <li>
                      <a href="#Gdrawcolorlerpnormalizedvalue-colors-fulloutput">lerp()</a>
                    </li>
                    <li>
                      <a href="#Gdrawcolormodifyhslcolor-h-s-l">modifyHSL()</a>
                    </li>
                    <li>
                      <a href="#Gdrawcolorparsecolorstr-rgbaarr">parse()</a>
                    </li>
                    <li>
                      <a href="#Gdrawcolortohexcolor">toHex()</a>
                    </li>
                    <li>
                      <a href="#Gdrawcolorstringifyarrcolor-type">stringify()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdrawdisplayable" class="primary">.Displayable</a>
                  <ol>
                    <li>
                      <a href="#Gdrawdisplayablecontainx-y">contain()</a>
                    </li>
                    <li>
                      <a href="#Gdrawdisplayabledirty">dirty()</a>
                    </li>
                    <li>
                      <a href="#Gdrawdisplayablegetboundingrect">getBoundingRect()</a>
                    </li>
                    <li>
                      <a href="#Gdrawdisplayablerectcontainx-y">rectContain()</a>
                    </li>

                    <li>
                      <a href="#Gdrawarc" class="primary">.Arc</a>
                    </li>
                    <li>
                      <a href="#Gdrawbeziercurve" class="primary">.BezierCurve</a>
                    </li>
                    <li>
                      <a href="#Gdrawcircle" class="primary">.Circle</a>
                    </li>
                    <li>
                      <a href="#Gdrawcompoundpath" class="primary">.CompoundPath</a>
                    </li>
                    <li>
                      <a href="#Gdrawdroplet" class="primary">.Droplet</a>
                    </li>
                    <li>
                      <a href="#Gdrawellipse" class="primary">.Ellipse</a>
                    </li>
                    <li>
                      <a href="#Gdrawheart" class="primary">.Heart</a>
                    </li>
                    <li>
                      <a href="#Gdrawimage" class="primary">.Image</a>
                    </li>
                    <li>
                      <a href="#Gdrawisogon" class="primary">.Isogon</a>
                    </li>
                    <li>
                      <a href="#Gdrawline" class="primary">.Line</a>
                    </li>
                    <li>
                      <a href="#Gdrawpath" class="primary">.Path</a>
                      <ol>
                        <li>
                          <a href="#Gdrawpathextendprops">Path.extend()</a>
                        </li>
                      </ol>
                    </li>
                    <li>
                      <a href="#Gdrawpolygon" class="primary">.Polygon</a>
                    </li>
                    <li>
                      <a href="#Gdrawpolyline" class="primary">.Polyline</a>
                    </li>
                    <li>
                      <a href="#Gdrawrect" class="primary">.Rect</a>
                    </li>
                    <li>
                      <a href="#Gdrawrose" class="primary">.Rose</a>
                    </li>
                    <li>
                      <a href="#Gdrawsector" class="primary">.Sector</a>
                    </li>
                    <li>
                      <a href="#Gdrawstar" class="primary">.Star</a>
                    </li>
                    <li>
                      <a href="#Gdrawtext" class="primary">.Text</a>
                    </li>
                    <li>
                      <a href="#Gdrawtrochoid" class="primary">.Trochoid</a>
                    </li>
                  </ol>
                </li>
                <li>
                  <a href="#Gdrawelement" class="primary">.Element</a>
                  <ol>
                    <li>
                      <a href="#Gdrawelementafterupdate">afterUpdate</a>
                    </li>
                    <li>
                      <a href="#Gdrawelementattrkey-value">attr()</a>
                    </li>
                    <li>
                      <a href="#Gdrawelementbeforeupdate">beforeUpdate</a>
                    </li>
                    <li>
                      <a href="#Gdrawelementhide">hide()</a>
                    </li>
                    <li>
                      <a href="#Gdrawelementremoveclippath">removeClipPath()</a>
                    </li>
                    <li>
                      <a href="#Gdrawelementsetclippathclippath">setClipPath()</a>
                    </li>
                    <li>
                      <a href="#Gdrawelementshow">show()</a>
                    </li>
                    <li>
                      <a href="#Gdrawelementtraversecb-context">traverse()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdraweventful" class="primary">.Eventful</a>
                  <ol>
                    <li>
                      <a href="#Gdraweventfulissilentevent">isSilent()</a>
                    </li>
                    <li>
                      <a href="#Gdraweventfuloffevent-handler">off()</a>
                    </li>
                    <li>
                      <a href="#Gdraweventfulonevent-handler-context">on()</a>
                    </li>
                    <li>
                      <a href="#Gdraweventfuloneevent-handler-context">one()</a>
                    </li>
                    <li>
                      <a href="#Gdraweventfultriggerevent">trigger()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdrawgradient" class="primary">.Gradient</a>
                  <ol>
                    <li>
                      <a href="#Gdrawgradientaddcolorstopoffset-color">addColorStop()</a>
                    </li>
                  </ol>
                </li>
                <li>
                  <a href="#Gdrawgroup" class="primary">.Group</a>
                  <ol>
                    <li>
                      <a href="#Gdrawgroupaddchild">add()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupaddbeforechild-nextsibling">addBefore()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupchildatidx">childAt()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupchildcount">childCount()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupchildofnamename">childOfName()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupchildren">children()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupdirty">dirty()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupeachchildcb-context">eachChild()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupgetboundingrectincludechildren">getBoundingRect()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupremovechild">remove()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupremoveall">removeAll()</a>
                    </li>
                    <li>
                      <a href="#Gdrawgroupsilent">silent</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdrawlineargradient" class="primary">.LinearGradient</a>
                </li>

                <li>
                  <a href="#Gdrawmatrix" class="primary">.matrix</a>
                  <ol>
                    <li>
                      <a href="#Gdrawmatrixcopyout-m">copy()</a>
                    </li>
                    <li>
                      <a href="#Gdrawmatrixcreate">create()</a>
                    </li>
                    <li>
                      <a href="#Gdrawmatrixidentityout">identity()</a>
                    </li>
                    <li>
                      <a href="#Gdrawmatrixinvertout-m">invert()</a>
                    </li>
                    <li>
                      <a href="#Gdrawmatrixmulout-m1-m2">mul()</a>
                    </li>
                    <li>
                      <a href="#Gdrawmatrixrotateout-m-rad">rotate()</a>
                    </li>
                    <li>
                      <a href="#Gdrawmatrixscaleout-m-v">scale()</a>
                    </li>
                    <li>
                      <a href="#Gdrawmatrixtranslateout-m-v">translate()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdraw-path" class="primary">.path</a>
                  <ol>
                    <li>
                      <a href="#Gdrawpathcreatefromstringstr-opts">createFromString()</a>
                    </li>
                    <li>
                      <a href="#Gdrawpathextendfromstringstr-opts">extendFromString()</a>
                    </li>
                    <li>
                      <a href="#Gdrawpathmergepathpathels-opts">mergePath()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdrawpattern" class="primary">.Pattern</a>
                </li>

                <li>
                  <a href="#Gdrawradialgradient" class="primary">.RadialGradient</a>
                </li>

                <li>
                  <a href="#Gdrawtransformable" class="primary">.Transformable</a>
                  <ol>
                    <li>
                      <a href="#Gdrawtransformabledecomposetransform">decomposeTransform()</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformablegetglobalscale">getGlobalScale()</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformableorigin">origin</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformableposition">position</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformablerotation">rotation</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformablescale">scale</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformabletransform">transform</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformabletransformcoordtoglobalx-y">transformCoordToGlobal()</a>
                    </li>
                    <li>
                      <a href="#Gdrawtransformabletransformcoordtolocalx-y">transformCoordToLocal()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdrawutil" class="primary">.util</a>
                  <ol>
                    <li>
                      <a href="#Gdrawutilbindfunc-context">bind()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilclonesource">clone()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilcreatecanvas">createCanvas()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilcurryfunc">curry()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutildefaultstarget-source-overlay">defaults()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutileacharray-cb-context">each()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilextendtarget-source">extend()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilfilterarray-cb-context">filter()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilfindarray-cb-context">find()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilgetcontext">getContext()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilindexofarray-value">indexOf()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilinheritsclazz-baseclazz">inherits()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilisarraydata">isArray()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilisfunctiondata">isFunction()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilisobjectdata">isObject()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilisstringdata">isString()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilmaparray-cb-context">map()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilmergetarget-source-overwrite">merge()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilreducearray-cb-context">reduce()</a>
                    </li>
                    <li>
                      <a href="#Gdrawutilslicearray-start-end">slice()</a>
                    </li>
                  </ol>
                </li>

                <li>
                  <a href="#Gdrawvector" class="primary">.vector</a>
                  <ol>
                    <li>
                      <a href="#Gdrawvectoraddout-v1-v2">add()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorapplytransformout-v-m">applyTransform()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorcopyout-v">copy()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorclonev">clone()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectordistancev1-v2">distance()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectordistancesquarev1-v2">distanceSquare()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectordivout-v1-v2">div()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectordotv1-v2">dot()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorlenv">len()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorlensquarev">lenSquare()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorlerpout-v1-v2-t">lerp()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectormaxout-v1-v2">max()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorminout-v1-v2">min()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectormulout-v1-v2">mul()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectornegateout-v">negate()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectornormalizeout-v">normalize()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorscaleout-v-s">scale()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorscaleandaddout-v1-v2-scale">scaleAndAdd()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorsetout-a-b">set()</a>
                    </li>
                    <li>
                      <a href="#Gdrawvectorsubout-v1-v2">sub()</a>
                    </li>
                  </ol>
                </li>
              </ol>

              <hr>


            </div>
          </el-scrollbar>
        </div><!-- end of sidebar -->

        <div class="api-content">
          <h2 id="Gdraw-api">Gdraw</h2>
          蓝色目录为静态属性/方法，灰色目录为实例属性/方法，所有功能类为方便调用全都赋值为Gdraw类的静态属性上，按照字母A-Z排序。
          <h4 >构造函数</h4>
          <p><code class="highlighter-rouge">Gdraw(dom,opts)</code></p>
          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>dom</td>
              <td><code class="highlighter-rouge">HTMLElement</code></td>
              <td> </td>
              <td>Gdraw 容器，在调用该方法时，应该已有宽度和高度。</td>
            </tr>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项</td>
            </tr>
            <tr>
              <td>opts.renderer</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'canvas'</code></td>
              <td>渲染方式，支持：<code class="highlighter-rouge">'canavs'</code>、<code class="highlighter-rouge">'svg'</code>、<code class="highlighter-rouge">'vml'</code></td>
            </tr>
            <tr>
              <td>opts.devicePixelRatio</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">2</code></td>
              <td>画布大小与容器大小之比，仅当 <code class="highlighter-rouge">renderer</code> 为 <code class="highlighter-rouge">'canvas'</code> 时有效。</td>
            </tr>
            <tr>
              <td>opts.width</td>
              <td><code class="highlighter-rouge">number|string</code></td>
              <td><code class="highlighter-rouge">'auto'</code></td>
              <td>画布宽度，设为 <code class="highlighter-rouge">'auto'</code> 则根据 <code class="highlighter-rouge">devicePixelRatio</code> 与容器宽度自动计算。</td>
            </tr>
            <tr>
              <td>opts.height</td>
              <td><code class="highlighter-rouge">number|string</code></td>
              <td><code class="highlighter-rouge">'auto'</code></td>
              <td>画布高度，设为 <code class="highlighter-rouge">'auto'</code> 则根据 <code class="highlighter-rouge">devicePixelRatio</code> 与容器高度自动计算。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>类型：<code class="highlighter-rouge">Gdraw</code>，<a href="#Gdraw-instance-api">Gdraw 实例</a>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawdisposezr">Gdraw.dispose</a>。</p>


          <h3 id="Gdrawversion">Gdraw.version</h3>

          <p>静态属性，类型：<code class="highlighter-rouge">'string'</code>，Gdraw 版本号。</p>

          <h3 id="Gdrawdisposezr">Gdraw.dispose(Gdraw)</h3>

          <p>静态方法，销毁 Gdraw 实例。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>gd</td>
              <td><code class="highlighter-rouge">Gdraw</code></td>
              <td> </td>
              <td>Gdraw 实例，不传则销毁全部Gdraw的实例。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>类型：<code class="highlighter-rouge">Gdraw</code>，<code class="highlighter-rouge">Gdraw</code> 类。</p>


          <h3 id="addel">Gdraw.add(el)</h3>

          <p>向画布内添加元素。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>el</td>
              <td><code class="highlighter-rouge">Element</code></td>
              <td> </td>
              <td>向画布内添加的元素。被添加的元素可以通过 <a href="#removeel"><code class="highlighter-rouge">remove(el)</code></a> 移除。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#removeel">Gdraw.remove</a>。</p>


          <h3 id="addhoverel-style">Gdraw.addHover(el, style)</h3>

          <p>将元素添加到高亮层。添加到高亮层后，可以通过 <a href="#removehoverel"><code class="highlighter-rouge">removeHover</code></a> 移除。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>el</td>
              <td><code class="highlighter-rouge">Element</code></td>
              <td> </td>
              <td>待添加的元素。</td>
            </tr>
            <tr>
              <td>style</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>元素样式。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#removehoverel"><code class="highlighter-rouge">Gdraw.removeHover</code></a>。</p>


          <h3 id="animation">Gdraw.animation</h3>

          <p>类型：<code class="highlighter-rouge">Animatoin</code>，动画。</p>


          <h3 id="clear">Gdraw.clear()</h3>

          <p>清除所有对象和画布。</p>


          <h3 id="clearanimation">Gdraw.clearAnimation()</h3>

          <p>停止所有动画。</p>


          <h3 id="clearhover">Gdraw.clearHover()</h3>

          <p>清除高亮层中所有的元素。</p>

          <h4 >相关</h4>

          <p><a href="#removehoverel"><code class="highlighter-rouge">Gdraw.removeHover</code></a>、<a href="#addhoverel"><code class="highlighter-rouge">addHover</code></a>。</p>


          <h3 id="configlayerzlevel-config">Gdraw.configLayer(zLevel, config)</h3>

          <p>改变某个层的配置。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>zlevel</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>层级，<code class="highlighter-rouge">zlevel</code> 更大的层将覆盖更小的层。</td>
            </tr>
            <tr>
              <td>config</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项。</td>
            </tr>
            <tr>
              <td>config.clearColor</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'#000'</code></td>
              <td>用于清除画布的颜色，默认为黑色。</td>
            </tr>
            <tr>
              <td>config.motionBlur</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否对该层采用动态模糊。</td>
            </tr>
            <tr>
              <td>config.lastFrameAlpha</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0.7</code></td>
              <td>用于动态模糊的混合因子，表示上一帧画面保留的比例。应介于 <code class="highlighter-rouge">0</code> 与 <code class="highlighter-rouge">1</code> 之间，<code class="highlighter-rouge">0</code> 表示完全使用当前帧，<code class="highlighter-rouge">1</code> 表示完全使用上一帧的画面。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="dispose">Gdraw.dispose()</h3>

          <p>移除自身。当不再需要使用该实例时，调用该方法以释放内存。</p>


          <h3 id="dom">Gdraw.dom</h3>

          <p>类型：<code class="highlighter-rouge">HTMLDomElement</code>，绘图容器。</p>

          <h3 id="find">Gdraw.find(id)</h3>

          <p>根据id获得元素。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>id</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td> </td>
              <td>需要获取的元素id</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>类型：<code class="highlighter-rouge">Element</code>，一个可以被添加的元素</p>

          <h3 id="flush">Gdraw.flush()</h3>

          <p>立即触发 refresh 和 refreshHover 所标记的重绘操作。</p>


          <h3 id="getheight">Gdraw.getHeight()</h3>

          <p>获取画布高度。</p>

          <h4 >相关</h4>

          <p><a href="#getwidth">Gdraw.getWidth</a>。</p>


          <h3 id="getwidth">Gdraw.getWidth()</h3>

          <p>获取画布宽度。</p>

          <h4 >相关</h4>

          <p><a href="#getheight">Gdraw.getHeight</a>。</p>


          <h3 id="getDataURL">Gdraw.getDataURL(opts)</h3>

          <p>获取当前图形的base64 url。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts.type</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td><code class="highlighter-rouge">'all'</code> </td>
              <td>获取类型,支持'window'、'all'</td>
            </tr>
            <tr>
              <td>opts.format</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td><code class="highlighter-rouge">'png'</code></td>
              <td>图片格式</td>
            </tr>
            <tr>
              <td>opts.backgroundColor</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td> </td>
              <td>为图片添加的背景颜色</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>类型：<code class="highlighter-rouge">Base64</code></p>

          <h3 id="id">Gdraw.id</h3>

          <p>类型：<code class="highlighter-rouge">string</code>，<code class="highlighter-rouge">Gdraw</code> 实例的唯一标识符。</p>


          <h3 id="offeventname-eventhandler">Gdraw.off(eventName, eventHandler)</h3>

          <p>取消绑定事件处理。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><code class="highlighter-rouge">eventName</code></td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名称，支持： <code class="highlighter-rouge">'click'</code>、 <code class="highlighter-rouge">'mousedown'</code>、 <code class="highlighter-rouge">'mouseup'</code>、 <code class="highlighter-rouge">'mousewheel'</code>、 <code class="highlighter-rouge">'dblclick'</code>、 <code class="highlighter-rouge">'contextmenu'</code>。</td>
            </tr>
            <tr>
              <td><code class="highlighter-rouge">eventHandler</code></td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>事件处理的回调函数。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#oneventname-eventhandler-context">Gdraw.on</a>。</p>


          <h3 id="oneventname-eventhandler-context">Gdraw.on(eventName, eventHandler, context)</h3>

          <p>绑定事件处理。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><code class="highlighter-rouge">eventName</code></td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名称，支持： <code class="highlighter-rouge">'click'</code>、 <code class="highlighter-rouge">'mousedown'</code>、 <code class="highlighter-rouge">'mouseup'</code>、 <code class="highlighter-rouge">'mousewheel'</code>、 <code class="highlighter-rouge">'dblclick'</code>、 <code class="highlighter-rouge">'contextmenu'</code>。</td>
            </tr>
            <tr>
              <td><code class="highlighter-rouge">eventHandler</code></td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>事件处理的回调函数。</td>
            </tr>
            <tr>
              <td><code class="highlighter-rouge">context</code></td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>函数上下文。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#offeventname-eventhandler">Gdraw.off</a>。</p>


          <h3 id="refresh">Gdraw.refresh()</h3>

          <p>刷新画布，将在下一个渲染帧的时候被刷新。</p>


          <h3 id="refreshhover">Gdraw.refreshHover()</h3>

          <p>刷新高亮层，将在下一个渲染帧的时候被刷新。</p>


          <h3 id="refreshhoverimmediately">Gdraw.refreshHoverImmediately()</h3>

          <p>强制立即刷新高亮层。</p>


          <h3 id="refreshimmediately">Gdraw.refreshImmediately()</h3>

          <p>强制立即刷新画布。</p>


          <h3 id="removeel">Gdraw.remove(el)</h3>

          <p>从画布内移除元素。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>el</td>
              <td><code class="highlighter-rouge">Element</code></td>
              <td> </td>
              <td>通过 <a href="#addel"><code class="highlighter-rouge">add(el)</code></a> 添加到画布的元素。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#addel">Gdraw.add</a>。</p>


          <h3 id="removehoverel">Gdraw.removeHover(el)</h3>

          <p>将元素从高亮层移除。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>el</td>
              <td><code class="highlighter-rouge">Element</code></td>
              <td> </td>
              <td>待删除的元素。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#addhoverel">Gdraw.addHover</a>。</p>



          <h3 id="resizeopts">Gdraw.resize(opts)</h3>

          <p>更新画布大小。当容器改变大小时，应调用此方法。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><code class="highlighter-rouge">opts</code></td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>宽高配置项</td>
            </tr>
            <tr>
              <td><code class="highlighter-rouge">opts.width</code></td>
              <td><code class="highlighter-rouge">number|string</code></td>
              <td><code class="highlighter-rouge">'auto'</code></td>
              <td>宽度，设为 <code class="highlighter-rouge">'auto'</code> 与设为 <code class="highlighter-rouge">null</code> 或 <code class="highlighter-rouge">undefined</code> 的效果相同，相当于自动获取容器宽度以改变画布宽度。</td>
            </tr>
            <tr>
              <td><code class="highlighter-rouge">opts.height</code></td>
              <td><code class="highlighter-rouge">number|string</code></td>
              <td><code class="highlighter-rouge">'auto'</code></td>
              <td>高度，设为 <code class="highlighter-rouge">'auto'</code> 与设为 <code class="highlighter-rouge">null</code> 或 <code class="highlighter-rouge">undefined</code> 的效果相同，相当于自动获取容器高度以改变画布高度。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="savePicture">Gdraw.savePicture()</h3>

          <p>导出当前图形</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts.name</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td><code class="highlighter-rouge"></code> </td>
              <td>文件名，需要文件后缀，与format的类型一致</td>
            </tr>
            <tr>
              <td>opts.type</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td><code class="highlighter-rouge">'all'</code> </td>
              <td>获取类型,支持'window'、'all'</td>
            </tr>
            <tr>
              <td>opts.format</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td><code class="highlighter-rouge">'png'</code></td>
              <td>图片格式</td>
            </tr>
            <tr>
              <td>opts.backgroundColor</td>
              <td><code class="highlighter-rouge">String</code></td>
              <td> </td>
              <td>为图片添加的背景颜色</td>
            </tr>
            </tbody>
          </table>

          <h3 id="triggereventname-event">Gdraw.trigger(eventName, event)</h3>

          <p>手动触发事件。</p>

          <h4>参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><code class="highlighter-rouge">eventName</code></td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名称，支持： <code class="highlighter-rouge">'click'</code>、 <code class="highlighter-rouge">'mousedown'</code>、 <code class="highlighter-rouge">'mouseup'</code>、 <code class="highlighter-rouge">'mousewheel'</code>、 <code class="highlighter-rouge">'dblclick'</code>、 <code class="highlighter-rouge">'contextmenu'</code>。</td>
            </tr>
            <tr>
              <td><code class="highlighter-rouge">event</code></td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>事件对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#oneventname-eventhandler-context">Gdraw.on</a>、<a href="#offeventname-eventhandler">off</a>。</p>

          <h3 id="Gdrawanimatable">Gdraw.Animatable</h3>

          <p>支持动画的对象。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Animatable()</code></p>

          <h3 id="Gdrawanimatableanimatepath-loop">Gdraw.Animatable.animate(path, loop)</h3>

          <p>创建一个动画对象。动画不会立即开始，如需立即开始，需调用 <a href=""><code class="highlighter-rouge">Gdraw.Animator.start</code></a>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>path</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>对该对象的哪个元素执行动画，如 <code class="highlighter-rouge">xxx.animate('a.b', true)</code> 表示对 <code class="highlighter-rouge">xxx.a.b</code> （可能是一个 <code class="highlighter-rouge">Object</code> 类型）执行动画。</td>
            </tr>
            <tr>
              <td>loop</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否循环动画。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>动画对象，类型：<a href="#Gdrawanimator">Animator</a>。</p>

          <h4 >例子</h4>

          <div class="language-js highlighter-rouge"><pre class="highlight"><code><span class="nx">el</span><span class="p">.</span><span class="nx">animate</span><span class="p">(</span><span class="s1">'style'</span><span class="p">,</span> <span class="kc">false</span><span class="p">)</span>
    <span class="p">.</span><span class="nx">when</span><span class="p">(</span><span class="mi">1000</span><span class="p">,</span> <span class="p">{</span><span class="na">x</span><span class="p">:</span> <span class="mi">10</span><span class="p">})</span>
    <span class="p">.</span><span class="nx">done</span><span class="p">(</span><span class="kd">function</span> <span class="p">()</span> <span class="p">{</span>
         <span class="c1">// Animation done</span>
    <span class="p">})</span>
    <span class="p">.</span><span class="nx">start</span><span class="p">()</span>
</code></pre>
          </div>

          <h3 id="Gdrawanimatableanimatetotarget-time-delay-easing-callback-forceanimate">Gdraw.Animatable.animateTo(target, time, delay, easing, callback, forceAnimate)</h3>

          <p>为属性设置动画。</p>

          <p>部分参数可缺省，支持以下形式的调用：</p>

          <ul>
            <li>animateTo(target, time, delay, easing, callback, forceAnimate)</li>
            <li>animateTo(target, time, delay, easing, callback)</li>
            <li>animateTo(target, time, easing, callback)</li>
            <li>animateTo(target, time, delay, callback)</li>
            <li>animateTo(target, time, callback)</li>
            <li>animateTo(target, callback)</li>
            <li>animateTo(target)</li>
          </ul>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>target</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>设置动画的对象，应为 <code class="highlighter-rouge">this</code> 的属性。</td>
            </tr>
            <tr>
              <td>time</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">500</code></td>
              <td>动画时长，单位毫秒。</td>
            </tr>
            <tr>
              <td>delay</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>动画延迟执行的时长，单位毫秒。</td>
            </tr>
            <tr>
              <td>easing</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'linear'</code></td>
              <td>缓动函数名称，支持的名称参见<a href="http://echarts.baidu.com/gallery/editor.html?c=line-easing">缓动函数</a>。</td>
            </tr>
            <tr>
              <td>callback</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>动画执行完成后的回调函数。</td>
            </tr>
            <tr>
              <td>forceAnimate</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>对于相同的属性，是否强制执行（也就是不直接结束动画）。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="例子-1">例子</h4>

          <div class="language-js highlighter-rouge"><pre class="highlight"><code><span class="c1">// Animate position</span>
<span class="nx">el</span><span class="p">.</span><span class="nx">animateTo</span><span class="p">({</span>
    <span class="na">position</span><span class="p">:</span> <span class="p">[</span><span class="mi">10</span><span class="p">,</span> <span class="mi">10</span><span class="p">]</span>
<span class="p">},</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span>
    <span class="c1">// done</span>
<span class="p">});</span>

<span class="c1">// Animate shape, style and position in 100ms, delayed 100ms,</span>
<span class="c1">// with cubicOut easing</span>
<span class="nx">el</span><span class="p">.</span><span class="nx">animateTo</span><span class="p">({</span>
    <span class="na">shape</span><span class="p">:</span> <span class="p">{</span>
        <span class="na">width</span><span class="p">:</span> <span class="mi">500</span>
    <span class="p">},</span>
    <span class="na">style</span><span class="p">:</span> <span class="p">{</span>
        <span class="na">fill</span><span class="p">:</span> <span class="s1">'red'</span>
    <span class="p">}</span>
    <span class="nl">position</span><span class="p">:</span> <span class="p">[</span><span class="mi">10</span><span class="p">,</span> <span class="mi">10</span><span class="p">]</span>
<span class="p">},</span> <span class="mi">100</span><span class="p">,</span> <span class="mi">100</span><span class="p">,</span> <span class="s1">'cubicOut'</span><span class="p">,</span> <span class="kd">function</span> <span class="p">()</span> <span class="p">{</span>
    <span class="c1">// done</span>
<span class="p">});</span>
</code></pre>
          </div>

          <h3 id="Gdrawanimatablestopanimationforwardtolast">Gdraw.Animatable.stopAnimation(forwardToLast)</h3>

          <p>停止动画。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>forwardToLast</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否将动画跳到最后一帧。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>


          <h3 id="Gdrawanimator">Gdraw.Animator</h3>

          <p>动画对象。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Animator()</code></p>

          <h3 id="Gdrawanimatordelaytime">Gdraw.Animator.delay(time)</h3>

          <p>设置动画延迟开始的时间。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>time</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>延迟时长，单位毫秒。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h3 id="Gdrawanimatordonecallback">Gdraw.Animator.done(callback)</h3>

          <p>设置动画结束的回调函数。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>callback</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>动画结束的回调函数。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h3 id="Gdrawanimatorduringcallback">Gdraw.Animator.during(callback)</h3>

          <p>为关键帧添加回调函数，在关键帧运行后执行。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>callback</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>关键帧回调函数。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h3 id="Gdrawanimatorispaused">Gdraw.Animator.isPaused()</h3>

          <p>获得动画是否处于暂停状态。</p>

          <h4 >返回值</h4>

          <p>是否暂停，类型：<code class="highlighter-rouge">boolean</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawanimatorpause"><code class="highlighter-rouge">Gdraw.Animator.pause</code></a>、 <a href="#Gdrawanimatorresume"><code class="highlighter-rouge">Gdraw.Animator.resume</code></a>。</p>

          <h3 id="Gdrawanimatorpause">Gdraw.Animator.pause()</h3>

          <p>暂停动画。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawanimatorresume"><code class="highlighter-rouge">Gdraw.Animator.resume</code></a>、 <a href="#Gdrawanimatorispaused"><code class="highlighter-rouge">Gdraw.Animator.isPaused</code></a>。</p>

          <h3 id="Gdrawanimatorresume">Gdraw.Animator.resume()</h3>

          <p>恢复动画。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawanimatorispaused"><code class="highlighter-rouge">Gdraw.Animator.isPaused</code></a>、 <a href="#Gdrawanimatorpause"><code class="highlighter-rouge">Gdraw.Animator.pause</code></a>。</p>

          <h3 id="Gdrawanimatorstarteasing">Gdraw.Animator.start(easing)</h3>

          <p>开始执行动画。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>easing</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'linear'</code></td>
              <td>缓动函数名称，支持的名称参见<a href="http://echarts.baidu.com/gallery/editor.html?c=line-easing">缓动函数</a>。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawanimatorpause"><code class="highlighter-rouge">Gdraw.Animator.pause</code></a>、 <a href="#Gdrawanimatorstopforwardtolast"><code class="highlighter-rouge">Gdraw.Animator.stop</code></a>。</p>

          <h3 id="Gdrawanimatorstopforwardtolast">Gdraw.Animator.stop(forwardToLast)</h3>

          <p>停止动画。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>forwardToLast</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否将动画跳到最后一帧。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#Gdrawanimatorstarteasing"><code class="highlighter-rouge">Gdraw.Animator.start</code></a>。</p>

          <h3 id="Gdrawanimatorwhentime-props">Gdraw.Animator.when(time, props)</h3>

          <p>定义关键帧，即动画对象在某个时刻的属性。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>time</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>关键帧时刻，单位毫秒。</td>
            </tr>
            <tr>
              <td>props</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>关键帧的属性，应为 <code class="highlighter-rouge">Animatable</code> 对象的属性。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>


          <h3 id="Gdrawboundingrect">Gdraw.BoundingRect</h3>

          <p>包围盒。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.BoundingRect(x, y, width, height)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>左上角横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>左上角纵坐标。</td>
            </tr>
            <tr>
              <td>width</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>包围盒宽度。</td>
            </tr>
            <tr>
              <td>height</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>包围盒高度。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawboundingrectclone">Gdraw.BoundingRect.clone()</h3>

          <p>得到包围盒的副本。</p>

          <h4 >返回值</h4>

          <p>新的包围盒，类型：<a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a>。</p>

          <h3 id="Gdrawboundingrectcontainx-y">Gdraw.BoundingRect.contain(x, y)</h3>

          <p>判断坐标 <code class="highlighter-rouge">(x, y)</code> 是否在图形上。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>纵坐标。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>返回是否在图形上，类型：<code class="highlighter-rouge">boolean</code>。</p>

          <h3 id="Gdrawboundingrectcopyother">Gdraw.BoundingRect.copy(other)</h3>

          <p>从另一个包围盒复制属性。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>other</td>
              <td><a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a></td>
              <td> </td>
              <td>另一个包围盒。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawboundingrectintersectother">Gdraw.BoundingRect.intersect(other)</h3>

          <p>判断两个包围盒是否相交。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>other</td>
              <td><a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a></td>
              <td> </td>
              <td>另一个包围盒。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>相交部分的包围盒，类型：<a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a>。</p>

          <h3 id="Gdrawboundingrectunionother">Gdraw.BoundingRect.union(other)</h3>

          <p>与另一个包围盒求并集，得到的也是一个包围盒。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>other</td>
              <td><a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a></td>
              <td> </td>
              <td>另一个包围盒。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>新的包围盒，类型：<a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a>。</p>


          <h3 id="Gdrawcolor">Gdraw.color</h3>

          <p><strong>静态属性</strong></p>

          <p>颜色工具</p>

          <h3 id="Gdrawcolorliftcolor-level">Gdraw.color.lift(color, level)</h3>

          <p>提亮颜色。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>color</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>原始颜色。</td>
            </tr>
            <tr>
              <td>level</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>提亮指数，应介于 <code class="highlighter-rouge">0</code> 与 <code class="highlighter-rouge">1</code> 之间，如果小于 <code class="highlighter-rouge">0</code>，颜色也会被提亮。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>提亮后的颜色，类型：<code class="highlighter-rouge">string</code>，形如 <code class="highlighter-rouge">rgba(...)</code> 或 <code class="highlighter-rouge">rgb(...)</code>。</p>

          <h3 id="Gdrawcolorlerpnormalizedvalue-colors-fulloutput">Gdraw.color.lerp(normalizedValue, colors, fullOutput)</h3>

          <p>快速得到渐变色 <code class="highlighter-rouge">colors</code> 在 <code class="highlighter-rouge">normalizedValue</code> 位置的颜色，返回混合后的颜色。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>normalizedValue</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>位置，范围 <code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">1</code>。</td>
            </tr>
            <tr>
              <td>colors</td>
              <td><code class="highlighter-rouge">string[]</code></td>
              <td> </td>
              <td>渐变色的数组。</td>
            </tr>
            <tr>
              <td>fullOutput</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>如果为 <code class="highlighter-rouge">true</code>，则返回包含 <code class="highlighter-rouge">color</code>、 <code class="highlighter-rouge">leftIndex</code>、 <code class="highlighter-rouge">rightIndex</code>、 <code class="highlighter-rouge">value</code> 的 <code class="highlighter-rouge">Object</code>，否则返回颜色。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>如果 <code class="highlighter-rouge">fullOutput</code> 为 <code class="highlighter-rouge">true</code>，则返回包含 <code class="highlighter-rouge">color</code>、 <code class="highlighter-rouge">leftIndex</code>、 <code class="highlighter-rouge">rightIndex</code>、 <code class="highlighter-rouge">value</code> 的 <code class="highlighter-rouge">Object</code>，否则返回颜色。类型：<code class="highlighter-rouge">Object|string</code>。</p>

          <h3 id="Gdrawcolormodifyalphacolor-alpha">Gdraw.color.modifyAlpha(color, alpha)</h3>

          <p>修改颜色的透明度维度。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>color</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>颜色字符串。</td>
            </tr>
            <tr>
              <td>alpha</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>新的透明度。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>RGBA 形式的颜色字符串。</p>

          <h3 id="Gdrawcolormodifyhslcolor-h-s-l">Gdraw.color.modifyHSL(color, h, s, l)</h3>

          <p>修改颜色的 HSL 维度。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>color</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>颜色字符串，可以不是 <code class="highlighter-rouge">hsl(...)</code> 形式的。</td>
            </tr>
            <tr>
              <td>h</td>
              <td><code class="highlighter-rouge">null|number</code></td>
              <td> </td>
              <td>如果为 <code class="highlighter-rouge">null</code>，则不改变。</td>
            </tr>
            <tr>
              <td>s</td>
              <td><code class="highlighter-rouge">null|number</code></td>
              <td> </td>
              <td>如果为 <code class="highlighter-rouge">null</code>，则不改变。</td>
            </tr>
            <tr>
              <td>l</td>
              <td><code class="highlighter-rouge">null|number</code></td>
              <td> </td>
              <td>如果为 <code class="highlighter-rouge">null</code>，则不改变。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>RGBA 形式的颜色字符串。</p>

          <h3 id="Gdrawcolorparsecolorstr-rgbaarr">Gdraw.color.parse(colorStr, rgbaArr)</h3>

          <p>将各种形式的颜色字符串，转成 RGBA 形式的数组输出。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>colorStr</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>可以是：<code class="highlighter-rouge">'rgb(100, 0, 0)'</code>、 <code class="highlighter-rouge">'rgba(0, 100, 0, 0.4)'</code>、<code class="highlighter-rouge">'red'</code>、 <code class="highlighter-rouge">'#F00'</code>、 <code class="highlighter-rouge">'#F60000'</code>、 <code class="highlighter-rouge">'hsla(270, 60%, 70%, 0.2)'</code>、 <code class="highlighter-rouge">'hsl(270, 60%, 70%)'</code> 之类的形式。</td>
            </tr>
            <tr>
              <td>rgba</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td> </td>
              <td>长度为 <code class="highlighter-rouge">4</code> 的数组，分别表示红色、绿色、蓝色、不透明度，前三者的取值范围是 <code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">255</code>，不透明度的取值范围是 <code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">1</code>。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>如果 <code class="highlighter-rouge">colorStr</code> 不是合法的颜色，则返回 <code class="highlighter-rouge">undefined</code>，否则返回 <code class="highlighter-rouge">rgbaArr</code>。类型：<code class="highlighter-rouge">undefined|number[]</code>。</p>

          <blockquote>
            <p>如果希望知道颜色字符串是否合法，应该使用返回值；如果希望在任何情况下都得到颜色，则应该使用参数 <code class="highlighter-rouge">rgbaArr</code>，如果颜色字符串不合法，会返回 <code class="highlighter-rouge">[0, 0, 0, 1]</code>，也就是黑色。</p>
          </blockquote>

          <h3 id="Gdrawcolortohexcolor">Gdraw.color.toHex(color)</h3>

          <p>将颜色转为十六进制的长度为 <code class="highlighter-rouge">6</code> 的字符串，开头没有 <code class="highlighter-rouge">'#'</code>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>color</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>颜色字符串。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>十六进制的颜色，类型：<code class="highlighter-rouge">string</code>。</p>

          <h4 >例子</h4>

          <p><code class="highlighter-rouge">Gdraw.color.toHex('rgb(200, 0, 0)')</code> 返回 <code class="highlighter-rouge">'c80000'</code>。</p>

          <h3 id="Gdrawcolorstringifyarrcolor-type">Gdraw.color.stringify(arrColor, type)</h3>

          <p>将数组形式的颜色转为字符串。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>arrColor</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td> </td>
              <td>可以是长度为 <code class="highlighter-rouge">3</code> 或 <code class="highlighter-rouge">4</code> 的数组，如 <code class="highlighter-rouge">[255, 0, 0, 0.2]</code>。</td>
            </tr>
            <tr>
              <td>type</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td><code class="highlighter-rouge">arrColor</code> 的形式，可以为：<code class="highlighter-rouge">'rgb'</code>、 <code class="highlighter-rouge">'rgba'</code>、 <code class="highlighter-rouge">'hsv'</code>、 <code class="highlighter-rouge">'hsva'</code>、 <code class="highlighter-rouge">'hsl'</code>、 <code class="highlighter-rouge">'hsla'</code>。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>颜色字符串，如：<code class="highlighter-rouge">'rgba(255, 0, 0, 0.2)'</code>，类型：<code class="highlighter-rouge">string</code>。</p>


          <h3 id="Gdrawdisplayable">Gdraw.Displayable</h3>

          <p><strong>继承自 <a href="#Gdrawelement">Gdraw.Element</a></strong></p>

          <p><strong>抽象类</strong></p>

          <p>可显示的元素。</p>

          <blockquote>
            <p><strong>注意：</strong></p>

            <p><code class="highlighter-rouge">Gdraw.Displayable</code> 是一个抽象类，所以不要在代码中 <code class="highlighter-rouge">new Gdraw.Displayable(opts)</code>，这里的构造函数只是用于表明其子类（如 <a href="#Gdrawrect">Rect</a> 等）构造函数参数的共同部分。</p>
          </blockquote>

          <p>元素初始化之后，需要通过 <a href="#Gdrawelementattrkey-value">Gdraw.Element.attr</a> 修改属性。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Displayable(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts.culling</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否进行裁剪。</td>
            </tr>
            <tr>
              <td>opts.cursor</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'pointer'</code></td>
              <td>鼠标移到元素上时的鼠标样式。</td>
            </tr>
            <tr>
              <td>opts.draggable</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>图形是否可拖曳。</td>
            </tr>
            <tr>
              <td>opts.invisible</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>图形是否不可见，为 <code class="highlighter-rouge">true</code> 时不绘制图形，但是仍能触发鼠标事件。</td>
            </tr>
            <tr>
              <td>opts.progressive</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">-1</code></td>
              <td>是否渐进式渲染。当图形元素过多时才使用，用大于 0 的数字表示渲染顺序。</td>
            </tr>
            <tr>
              <td>opts.rectHover</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否使用包围盒检验鼠标是否移动到物体。<code class="highlighter-rouge">false</code> 则检测元素实际的内容。</td>
            </tr>
            <tr>
              <td>opts.silent</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否响应鼠标事件。</td>
            </tr>
            <tr>
              <td>opts.style.fill</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'#000'</code></td>
              <td>填充样式。</td>
            </tr>
            <tr>
              <td>opts.style.stroke</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>描边样式。</td>
            </tr>
            <tr>
              <td>opts.style.opacity</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">1</code></td>
              <td>不透明度。</td>
            </tr>
            <tr>
              <td>opts.style.lineDash</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>描边虚线样式，参考 <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute/stroke-dasharray">SVG stroke-dasharray</a>。</td>
            </tr>
            <tr>
              <td>opts.style.lineDashOffset</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>描边虚线偏移，参考 <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute/stroke-dashoffset">SVG stroke-dashoffset</a>。</td>
            </tr>
            <tr>
              <td>opts.style.shadowBlur</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>阴影模糊大小。</td>
            </tr>
            <tr>
              <td>opts.style.shadowColor</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'transparent'</code></td>
              <td>阴影颜色。</td>
            </tr>
            <tr>
              <td>opts.style.shadowOffsetX</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>阴影横向偏移。</td>
            </tr>
            <tr>
              <td>opts.style.shadowOffsetY</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>阴影纵向偏移。</td>
            </tr>
            <tr>
              <td>opts.style.lineWidth</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>线宽。</td>
            </tr>
            <tr>
              <td>opts.style.strokeNoScale</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>描边粗细不随缩放而改变，<code class="highlighter-rouge">false</code> 则会根据缩放同比例缩放描边粗细。</td>
            </tr>
            <tr>
              <td>opts.style.text</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>在图形中显示的文字。</td>
            </tr>
            <tr>
              <td>opts.style.font</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字样式，由 <code class="highlighter-rouge">fontSize</code>、 <code class="highlighter-rouge">fontFamily</code>、 <code class="highlighter-rouge">fontStyle</code>、 <code class="highlighter-rouge">fontWeight</code> 组成，建议分别设置这几项而非直接设置 <code class="highlighter-rouge">font</code>。</td>
            </tr>
            <tr>
              <td>opts.style.fontStyle</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>同 <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/font-style">CSS font-style</a>。</td>
            </tr>
            <tr>
              <td>opts.style.fontWeight</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>同 <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/font-weight">CSS font-weight</a>。</td>
            </tr>
            <tr>
              <td>opts.style.fontSize</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>同 <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/font-size">CSS font-size</a>。</td>
            </tr>
            <tr>
              <td>opts.style.fontFamily</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>同 <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/font-family">CSS font-family</a>。</td>
            </tr>
            <tr>
              <td>opts.style.textFill</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字填充样式。</td>
            </tr>
            <tr>
              <td>opts.style.textStroke</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字描边样式。</td>
            </tr>
            <tr>
              <td>opts.style.textWidth</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字宽度。</td>
            </tr>
            <tr>
              <td>opts.style.textHeight</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字高度，仅用于设置背景色时需要设置。</td>
            </tr>
            <tr>
              <td>opts.style.textLineWidth</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字描边宽度。</td>
            </tr>
            <tr>
              <td>opts.style.textLineHeight</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字行高。</td>
            </tr>
            <tr>
              <td>opts.style.textPosition</td>
              <td><code class="highlighter-rouge">string|number[]</code></td>
              <td><code class="highlighter-rouge">'inside'</code></td>
              <td>文字位置，可以为 <code class="highlighter-rouge">'inside'</code>、 <code class="highlighter-rouge">'left'</code>、 <code class="highlighter-rouge">'right'</code>、 <code class="highlighter-rouge">'top'</code>、 <code class="highlighter-rouge">'bottom'</code>，或一个二维数组 <code class="highlighter-rouge">[x, y]</code> 表示相对形状的位置。</td>
            </tr>
            <tr>
              <td>opts.style.textRect</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字包围盒，包括 <code class="highlighter-rouge">x</code>、 <code class="highlighter-rouge">y</code>、 <code class="highlighter-rouge">width</code>、 <code class="highlighter-rouge">height</code> 属性，如果没有设置，将使用形状的包围盒。</td>
            </tr>
            <tr>
              <td>opts.style.textOffset</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字位置偏移，包括 <code class="highlighter-rouge">x</code>、 <code class="highlighter-rouge">y</code>。</td>
            </tr>
            <tr>
              <td>opts.style.textAlign</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字水平对齐方式，可取值：<code class="highlighter-rouge">'left'</code>、 <code class="highlighter-rouge">'center'</code>、 <code class="highlighter-rouge">'right'</code>，默认根据 <code class="highlighter-rouge">textPosition</code> 计算。</td>
            </tr>
            <tr>
              <td>opts.style.textVerticalAlign</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字垂直对齐方式，可取值：<code class="highlighter-rouge">'top'</code>、 <code class="highlighter-rouge">'middle'</code>、 <code class="highlighter-rouge">'bottom'</code>，默认根据 <code class="highlighter-rouge">textPosition</code> 计算。</td>
            </tr>
            <tr>
              <td>opts.style.textDistance</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">5</code></td>
              <td>文字与其对齐的边缘的距离，如 <code class="highlighter-rouge">textPosition</code> 为 <code class="highlighter-rouge">top</code> 时，<code class="highlighter-rouge">textDistance</code> 表示与形状上方的距离。</td>
            </tr>
            <tr>
              <td>opts.style.textShadowColor</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'transparent'</code></td>
              <td>文字阴影颜色。</td>
            </tr>
            <tr>
              <td>opts.style.textShadowBlur</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字阴影模糊大小。</td>
            </tr>
            <tr>
              <td>opts.style.textShadowOffsetX</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字阴影水平偏移。</td>
            </tr>
            <tr>
              <td>opts.style.textShadowOffsetY</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字阴影垂直偏移。</td>
            </tr>
            <tr>
              <td>opts.style.textBoxShadowColor</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'transparent'</code></td>
              <td>文字包围盒阴影颜色。</td>
            </tr>
            <tr>
              <td>opts.style.textBoxShadowBlur</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字包围盒阴影模糊大小。</td>
            </tr>
            <tr>
              <td>opts.style.textBoxShadowOffsetX</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字包围盒阴影水平偏移。</td>
            </tr>
            <tr>
              <td>opts.style.textBoxShadowOffsetY</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字包围盒阴影垂直偏移。</td>
            </tr>
            <tr>
              <td>opts.style.transformText</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>文字是否跟随变换效果，仅对 <code class="highlighter-rouge">Path</code> 或 <code class="highlighter-rouge">Image</code> 元素有效</td>
            </tr>
            <tr>
              <td>opts.style.textRotation</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字旋转角度，仅对 <code class="highlighter-rouge">Path</code> 或 <code class="highlighter-rouge">Image</code> 元素有效，并且 <code class="highlighter-rouge">transformText</code> 应设置为 <code class="highlighter-rouge">false</code>。</td>
            </tr>
            <tr>
              <td>opts.style.textOrigin</td>
              <td><code class="highlighter-rouge">string|number[]</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字变换中心，可以是 <code class="highlighter-rouge">'center'</code> 或一个二维数组 <code class="highlighter-rouge">[x, y]</code> 表示相对形状的位置，默认值是 <code class="highlighter-rouge">textPosition</code>。</td>
            </tr>
            <tr>
              <td>opts.style.textBackgroundColor</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字包围盒颜色。</td>
            </tr>
            <tr>
              <td>opts.style.textBorderColor</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字包围盒描边颜色。</td>
            </tr>
            <tr>
              <td>opts.style.textBorderWidth</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字包围盒描边宽度。</td>
            </tr>
            <tr>
              <td>opts.style.textBorderRadius</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>文字圆角大小。</td>
            </tr>
            <tr>
              <td>opts.style.textPadding</td>
              <td><code class="highlighter-rouge">number|number[]</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>文字内边距，可以是 <code class="highlighter-rouge">2</code> 或 <code class="highlighter-rouge">[2, 4]</code> 或 <code class="highlighter-rouge">[2, 3, 4, 5]</code> 的形式，同 <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/padding">CSS Padding</a>，单位是像素。</td>
            </tr>
            <tr>
              <td>opts.style.rich</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>富文本样式，参考 <a href="http://echarts.baidu.com/tutorial.html#%E5%AF%8C%E6%96%87%E6%9C%AC%E6%A0%87%E7%AD%BE">ECharts rich 配置项</a>。</td>
            </tr>
            <tr>
              <td>opts.style.truncate</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>当文字过长显示不下时，显示省略号表示。</td>
            </tr>
            <tr>
              <td>opts.style.truncate.outerWidth</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>包含了 <code class="highlighter-rouge">textPadding</code> 的宽度，超出这个范围就裁剪。</td>
            </tr>
            <tr>
              <td>opts.style.truncate.outerHeight</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>包含了 <code class="highlighter-rouge">textPadding</code> 的高度，超出这个范围就裁剪。</td>
            </tr>
            <tr>
              <td>opts.style.truncate.ellipsis</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'...'</code></td>
              <td>默认用省略号表示超出部分，也可以对其进行自定义。</td>
            </tr>
            <tr>
              <td>opts.style.truncate.placeholder</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>如果空间过小，导致省略号也显示不下，但是又不想空着，可能得有个什么标记表示这里是有字符的，就用个 “点”，就是在这个 placeholder 里设置。</td>
            </tr>
            <tr>
              <td>opts.style.blend</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>混合模式，同 <a href="https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/globalCompositeOperation">Canvas globalCompositeOperation</a>。</td>
            </tr>
            <tr>
              <td>opts.zlevel</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>决定绘画在哪层 Canvas 中。Canvas 分层是一种常见的优化手段。我们可以把一些图形变化频繁（例如有动画）的组件设置成一个单独的 <code class="highlighter-rouge">zlevel</code>。需要注意的是过多的 Canvas 会引起内存开销的增大，在手机端上需要谨慎使用以防崩溃。<code class="highlighter-rouge">zlevel</code> 大的 Canvas 会放在 <code class="highlighter-rouge">zlevel</code> 小的 Canvas 的上面。</td>
            </tr>
            <tr>
              <td>opts.z</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>控制图形的前后顺序。<code class="highlighter-rouge">z</code> 值小的图形会被 <code class="highlighter-rouge">z</code> 值大的图形覆盖。<code class="highlighter-rouge">z</code> 相比 <code class="highlighter-rouge">zlevel</code> 优先级更低，而且不会创建新的 Canvas。</td>
            </tr>
            <tr>
              <td>opts.z2</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>与 <code class="highlighter-rouge">z</code> 类似，优先级比 <code class="highlighter-rouge">z</code> 更低。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawdisplayablecontainx-y">Gdraw.Displayable.contain(x, y)</h3>

          <p>判断坐标 <code class="highlighter-rouge">(x, y)</code> 是否在图形上。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>纵坐标。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>返回是否在图形上，类型：<code class="highlighter-rouge">boolean</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawdisplayablerectcontainx-y">Gdraw.Displayable.rectContain</a>。</p>

          <h3 id="Gdrawdisplayabledirty">Gdraw.Displayable.dirty()</h3>

          <p>设为需要更新。</p>

          <h3 id="Gdrawdisplayablegetboundingrect">Gdraw.Displayable.getBoundingRect()</h3>

          <p>得到元素的包围盒。</p>

          <h4 >返回值</h4>

          <p>元素的包围盒，类型：<a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a>。</p>

          <h3 id="Gdrawdisplayablerectcontainx-y">Gdraw.Displayable.rectContain(x, y)</h3>

          <p>判断坐标 <code class="highlighter-rouge">(x, y)</code> 是否在图形包围盒内。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>纵坐标。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>返回是否在图形上，类型：<code class="highlighter-rouge">boolean</code>。</p>

          <h4 >相关</h4>

          <p><a href="">Gdraw.Displayable.contain</a></p>


          <h3 id="Gdrawarc">Gdraw.Arc</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>圆弧。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Arc(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>半径。</td>
            </tr>
            <tr>
              <td>opts.shape.startAngle</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>起始弧度。</td>
            </tr>
            <tr>
              <td>opts.shape.endAngle</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">Math.PI * 2</code></td>
              <td>终止弧度。</td>
            </tr>
            <tr>
              <td>opts.shape.clockwise</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">true</code></td>
              <td>顺时针方向。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawbeziercurve">Gdraw.BezierCurve</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>贝塞尔曲线。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.BezierCurve(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.x1</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>起始点横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.y1</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>起始点纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.x2</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>终止点横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.y2</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>终止点纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cpx1</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>控制点横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cpy1</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>控制点纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.percent</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">1</code></td>
              <td>已显示的百分比，用于绘制动画。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawcircle">Gdraw.Circle</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>圆。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Circle(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>半径。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawcompoundpath">Gdraw.CompoundPath</h3>

          <p><strong>继承自 <a href="#Gdrawpath">Gdraw.Path</a></strong></p>

          <p>复合路径。相当于多个路径的并集。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.CompoundPath(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape.paths</td>
              <td><a href="#Gdrawpath"><code class="highlighter-rouge">Path[]</code></a></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>路径数组。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawdroplet">Gdraw.Droplet</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>水滴。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Droplet(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.width</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>宽度。</td>
            </tr>
            <tr>
              <td>opts.shape.height</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>高度。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawellipse">Gdraw.Ellipse</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>椭圆。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Ellipse(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.rx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>横向半径。</td>
            </tr>
            <tr>
              <td>opts.shape.ry</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>纵向半径。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawheart">Gdraw.Heart</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>心形。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Heart(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.width</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>宽度。</td>
            </tr>
            <tr>
              <td>opts.shape.height</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>高度。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawimage">Gdraw.Image</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>图像。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Image(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.style</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>样式。</td>
            </tr>
            <tr>
              <td>opts.style.image</td>
              <td><code class="highlighter-rouge">string|HTMLImageElement|HTMLCanvasElement</code></td>
              <td> </td>
              <td>图片的内容，可以是图片的 URL，也可以是 <a href="https://tools.ietf.org/html/rfc2397">dataURI</a>。</td>
            </tr>
            <tr>
              <td>opts.style.x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>图片左上角相对于父节点的横坐标。</td>
            </tr>
            <tr>
              <td>opts.style.y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>图片左上角相对于父节点的纵坐标。</td>
            </tr>
            <tr>
              <td>opts.style.width</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>图片宽度。</td>
            </tr>
            <tr>
              <td>opts.style.height</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>图片高度。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawisogon">Gdraw.Isogon</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>正多边形。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Isogon(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>半径。</td>
            </tr>
            <tr>
              <td>opts.shape.n</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>边数。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawline">Gdraw.Line</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>线段。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Line(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.x1</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>起始点横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.y1</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>起始点纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.x2</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>终止点横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.y2</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>终止点纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.percent</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">1</code></td>
              <td>已显示的百分比，用于绘制动画。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawpath">Gdraw.Path</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>路径。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Path(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawpathextendprops">Gdraw.Path.extend(props)</h3>

          <p>扩展一个 <code class="highlighter-rouge">Path</code> 元素，用以生成比如星形，圆等。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.type</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>类型，自定义的名称。</td>
            </tr>
            <tr>
              <td>opts.init</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>初始化时调用的函数。</td>
            </tr>
            <tr>
              <td>opts.buildPath</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>如何构建 <code class="highlighter-rouge">Path</code> 的函数，在绘制时候会调用。</td>
            </tr>
            </tbody>
          </table>

          <h4 >例子</h4>

          <p><a href="https://github.com/ecomfe/Gdraw/blob/master/test/pin.html">这个例子</a>展示的是如何通过扩展 <code class="highlighter-rouge">Path</code> 得到新图形。</p>


          <h3 id="Gdrawpolygon">Gdraw.Polygon</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>多边形。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Polygon(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.points</td>
              <td><code class="highlighter-rouge">number[][]</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>每个元素是一个横纵坐标的数组。</td>
            </tr>
            <tr>
              <td>opts.shape.smooth</td>
              <td><code class="highlighter-rouge">number|string</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆滑程度，取值范围为 <code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">1</code> 之间的数字，<code class="highlighter-rouge">0</code> 表示不圆滑；也可以是特殊字符串 <code class="highlighter-rouge">'spline'</code> 表示用 Catmull-Rom spline 插值算法，否则默认用贝塞尔曲线插值算法。</td>
            </tr>
            <tr>
              <td>opts.shape.smoothConstraint</td>
              <td><code class="highlighter-rouge">number[][]</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>将计算出来的控制点约束在一个包围盒内。比如 <code class="highlighter-rouge">[[0, 0], [100, 100]]</code>，这个包围盒会与整个折线的包围盒做一个并集用来约束控制点。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p>如果要创建仅含描边的多边形，请使用 <a href="#Gdrawpolyline">Polyline</a>。</p>


          <h3 id="Gdrawpolyline">Gdraw.Polyline</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>多边形折线段。默认是不闭合的，如果需要闭合，请将最后一个点设为和第一个点同样的位置。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Polyline(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.points</td>
              <td><code class="highlighter-rouge">number[][]</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>每个元素是一个横纵坐标的数组。</td>
            </tr>
            <tr>
              <td>opts.shape.smooth</td>
              <td><code class="highlighter-rouge">number|string</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆滑程度，取值范围为 <code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">1</code> 之间的数字，<code class="highlighter-rouge">0</code> 表示不圆滑；也可以是特殊字符串 <code class="highlighter-rouge">'spline'</code> 表示用 Catmull-Rom spline 插值算法，否则默认用贝塞尔曲线插值算法。</td>
            </tr>
            <tr>
              <td>opts.shape.smoothConstraint</td>
              <td><code class="highlighter-rouge">number[][]</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>将计算出来的控制点约束在一个包围盒内。比如 <code class="highlighter-rouge">[[0, 0], [100, 100]]</code>，这个包围盒会与整个折线的包围盒做一个并集用来约束控制点。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p>如果要创建填充的多边形，请使用 <a href="#Gdrawpolygon">Polygon</a>。</p>


          <h3 id="Gdrawrect">Gdraw.Rect</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>矩形。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Rect(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number|number[]</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>用于创建圆角矩形。左上、右上、右下、左下角的半径依次为 r1、 r2、 r3、 r4。r 缩写为 1 相当于 [1, 1, 1, 1]；r 缩写为 [1] 相当于 [1, 1, 1, 1]；r 缩写为 [1, 2]    相当于 [1, 2, 1, 2]；r 缩写为 [1, 2, 3] 相当于 [1, 2, 3, 2]。</td>
            </tr>
            <tr>
              <td>opts.shape.x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>左上角的横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>左上角的纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.width</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>宽度。</td>
            </tr>
            <tr>
              <td>opts.shape.height</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>高度。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawrose">Gdraw.Rose</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>玫瑰线，参见 <a href="https://en.wikipedia.org/wiki/Rose_(mathematics)">wiki</a>。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Rose(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td>半径。</td>
            </tr>
            <tr>
              <td>opts.shape.k</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>玫瑰线参数，参见 <a href="https://en.wikipedia.org/wiki/Rose_(mathematics)">wiki</a>。</td>
            </tr>
            <tr>
              <td>opts.shape.n</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">1</code></td>
              <td>花瓣数。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawsector">Gdraw.Sector</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>扇形。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Sector(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>半径。</td>
            </tr>
            <tr>
              <td>opts.shape.r0</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>内半径。</td>
            </tr>
            <tr>
              <td>opts.shape.startAngle</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>起始弧度。</td>
            </tr>
            <tr>
              <td>opts.shape.endAngle</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">Math.PI * 2</code></td>
              <td>终止弧度。</td>
            </tr>
            <tr>
              <td>opts.shape.clockwise</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">true</code></td>
              <td>顺时针方向。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawstar">Gdraw.Star</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>星形。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Star(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.n</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">3</code></td>
              <td>瓣数，如 <code class="highlighter-rouge">n</code> 等于 <code class="highlighter-rouge">5</code> 时，是我们熟悉的五角星。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>半径。</td>
            </tr>
            <tr>
              <td>opts.shape.r0</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>内半径。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawtext">Gdraw.Text</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>文字。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Text(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawtrochoid">Gdraw.Trochoid</h3>

          <p><strong>继承自 <a href="#Gdrawdisplayable">Gdraw.Displayable</a></strong></p>

          <p>内外旋轮曲线，参见 <a href="https://en.wikipedia.org/wiki/Trochoid">wiki</a>。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Trochoid(opts)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，继承得到的配置项参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a>。</td>
            </tr>
            <tr>
              <td>opts.shape</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>形状属性。</td>
            </tr>
            <tr>
              <td>opts.shape.cx</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心横坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.cy</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>圆心纵坐标。</td>
            </tr>
            <tr>
              <td>opts.shape.r</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>半径。</td>
            </tr>
            <tr>
              <td>opts.shape.r0</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>内半径。</td>
            </tr>
            <tr>
              <td>opts.shape.d</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>内外旋轮曲线参数，参见 <a href="https://en.wikipedia.org/wiki/Trochoid">wiki</a>。</td>
            </tr>
            <tr>
              <td>opts.shape.n</td>
              <td><code class="highlighter-rouge">location</code></td>
              <td><code class="highlighter-rouge">'out'</code></td>
              <td><code class="highlighter-rouge">out</code> 或 <code class="highlighter-rouge">in</code>，表示曲线在内部还是外部。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawelement">Gdraw.Element</h3>

          <p><strong>继承自 <a href="#Gdrawanimatable">Gdraw.Animatable</a>、 <a href="#Gdrawtransformable">Gdraw.Transformable</a>、 <a href="#Gdraweventful">Gdraw.Eventful</a></strong></p>

          <p><strong>抽象类</strong></p>

          <p>元素，可以被添加到场景中。</p>

          <blockquote>
            <p><strong>注意：</strong></p>

            <p><code class="highlighter-rouge">Gdraw.Element</code> 是一个抽象类，所以不要在代码中 <code class="highlighter-rouge">new Gdraw.Element(opts)</code>，这里的构造函数只是用于表明其子类构造函数参数的共同部分。</p>
          </blockquote>

          <h3 id="Gdrawelementafterupdate">Gdraw.Element.afterUpdate</h3>

          <p>类型：<code class="highlighter-rouge">Function</code>，元素更新后的回调函数。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawelementbeforeupdate">Gdraw.Element.beforeUpdate</a>。</p>

          <h3 id="Gdrawelementattrkey-value">Gdraw.Element.attr(key, value)</h3>

          <p>设置元素属性。需要注意的是，应该始终调用该方法来修改属性，而不是直接 <code class="highlighter-rouge">element.xxx = ...</code> 这样的形式，因为后者不会重绘物体。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>key</td>
              <td><code class="highlighter-rouge">string|Object</code></td>
              <td> </td>
              <td>设置的属性。可以是 <code class="highlighter-rouge">string</code> 类型的属性名称，或者 <code class="highlighter-rouge">Object</code> 类型的属性及其值。</td>
            </tr>
            <tr>
              <td>value</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>属性值。</td>
            </tr>
            </tbody>
          </table>

          <h4 >例子</h4>

          <div class="language-js highlighter-rouge"><pre class="highlight"><code><span class="nx">element</span><span class="p">.</span><span class="nx">attr</span><span class="p">(</span><span class="s1">'position'</span><span class="p">,</span> <span class="p">[</span><span class="mi">100</span><span class="p">,</span> <span class="mi">200</span><span class="p">]);</span>
<span class="nx">element</span><span class="p">.</span><span class="nx">attr</span><span class="p">({</span>
    <span class="na">style</span><span class="p">:</span> <span class="p">{</span>
        <span class="na">fill</span><span class="p">:</span> <span class="s1">'red'</span>
    <span class="p">},</span>
    <span class="na">shape</span><span class="p">:</span> <span class="p">{</span>
        <span class="na">x</span><span class="p">:</span> <span class="mi">100</span>
    <span class="p">}</span>
<span class="p">});</span>
</code></pre>
          </div>

          <h3 id="Gdrawelementbeforeupdate">Gdraw.Element.beforeUpdate</h3>

          <p>类型：<code class="highlighter-rouge">Function</code>，元素更新前的回调函数。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawelementafterupdate">Gdraw.Element.afterUpdate</a>。</p>

          <h3 id="Gdrawelementhide">Gdraw.Element.hide()</h3>

          <p>隐藏元素，可以使用 <a href="#Gdrawelementshow">Gdraw.Element.show</a> 恢复显示。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawelementshow">Gdraw.Element.show</a>。</p>

          <h3 id="Gdrawelementremoveclippath">Gdraw.Element.removeClipPath()</h3>

          <p>取消设置裁剪元素。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawelementsetclippathclippath">Gdraw.Element.setClipPath</a>。</p>

          <h3 id="Gdrawelementsetclippathclippath">Gdraw.Element.setClipPath(clipPath)</h3>

          <p>设置裁剪元素，超出 <code class="highlighter-rouge">clipPath</code> 区域的部分将被裁剪掉。</p>

          <p>一个元素只能被一个元素裁剪，如果要实现多个元素的裁剪，需要使用 <a href="#Gdrawcompoundpath">Gdraw.CompoundPath</a>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>clipPath</td>
              <td><code class="highlighter-rouge">Element</code></td>
              <td> </td>
              <td>设置当前元素的裁剪元素。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#Gdrawelementremoveclippath">Gdraw.Element.removeClipPath</a>。</p>

          <h3 id="Gdrawelementshow">Gdraw.Element.show()</h3>

          <p>显示元素。元素在默认情况下是显示状态，使用 <a href="#Gdrawelementhide">Gdraw.Element.hide</a> 隐藏后，可以使用此方法显示。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawelementhide">Gdraw.Element.hide</a>。</p>

          <h3 id="Gdrawelementtraversecb-context">Gdraw.Element.traverse(cb, context)</h3>

          <p>深度优先遍历所有子孙节点。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>回调函数。接受参数：<code class="highlighter-rouge">context, child</code>，其中 <code class="highlighter-rouge">child</code> 是每个元素的子元素。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>执行回调函数的上下文。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdraweventful">Gdraw.Eventful</h3>

          <p>支持事件的元素。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Eventful()</code></p>

          <h3 id="Gdraweventfulissilentevent">Gdraw.Eventful.isSilent(event)</h3>

          <p>是否绑定了事件。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>event</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>是否绑定了事件，类型：<code class="highlighter-rouge">boolean</code>。</p>

          <h3 id="Gdraweventfuloffevent-handler">Gdraw.Eventful.off(event, handler)</h3>

          <p>解绑事件。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>event</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名。</td>
            </tr>
            <tr>
              <td>handler</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>响应函数。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdraweventfulonevent-handler-context">Gdraw.Eventful.on</a>。</p>

          <h3 id="Gdraweventfulonevent-handler-context">Gdraw.Eventful.on(event, handler, context)</h3>

          <p>绑定事件。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>event</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名。</td>
            </tr>
            <tr>
              <td>handler</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>响应函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdraweventfuloffevent-handler">Gdraw.Eventful.off</a>。</p>

          <h3 id="Gdraweventfuloneevent-handler-context">Gdraw.Eventful.one(event, handler, context)</h3>

          <p>单次触发绑定，触发后销毁。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>event</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名。</td>
            </tr>
            <tr>
              <td>handler</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>响应函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h3 id="Gdraweventfultriggerevent">Gdraw.Eventful.trigger(event)</h3>

          <p>触发事件。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>event</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>事件名。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p><code class="highlighter-rouge">this</code>。</p>


          <h3 id="Gdrawgradient">Gdraw.Gradient</h3>

          <p><strong>抽象类</strong></p>

          <p>渐变。</p>

          <blockquote>
            <p><strong>注意：</strong></p>

            <p><code class="highlighter-rouge">Gdraw.Gradient</code> 是一个抽象类，所以不要在代码中 <code class="highlighter-rouge">new Gdraw.Gradient(colorStops)</code>，这里的构造函数只是用于表明其子类构造函数参数的共同部分。</p>
          </blockquote>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Gradient(colorStops)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>colorStops</td>
              <td><code class="highlighter-rouge">Object[]</code></td>
              <td> </td>
              <td>组成渐变色的颜色。每个颜色包括 <code class="highlighter-rouge">offset</code> 与 <code class="highlighter-rouge">color</code> 属性，前者表示渐变位置（类型：<code class="highlighter-rouge">number</code>），后者表示具体的颜色（类型：<code class="highlighter-rouge">string</code>）</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawgradientaddcolorstopoffset-color">Gdraw.Gradient.addColorStop(offset, color)</h3>

          <p>增加渐变色。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td><code class="highlighter-rouge">offset</code></td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>渐变位置。</td>
            </tr>
            <tr>
              <td><code class="highlighter-rouge">color</code></td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>颜色。</td>
            </tr>
            </tbody>
          </table>

          <blockquote>
            <p>如果想要清除渐变色，可以使用 <code class="highlighter-rouge">this.colorStops = []</code>。</p>
          </blockquote>


          <h3 id="Gdrawgroup">Gdraw.Group</h3>

          <p><strong>继承自 <a href="#Gdrawelement">Gdraw.Element</a></strong></p>

          <p>组。Group 是一个容器，可以插入子节点，Group 的变换也会被应用到子节点上。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Group()</code></p>

          <h4 >例子</h4>

          <div class="language-js highlighter-rouge"><pre class="highlight"><code><span class="kd">var</span> <span class="nx">g</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">Gdraw</span><span class="p">.</span><span class="nx">Group</span><span class="p">();</span>
<span class="nx">g</span><span class="p">.</span><span class="nx">position</span><span class="p">[</span><span class="mi">0</span><span class="p">]</span> <span class="o">=</span> <span class="mi">100</span><span class="p">;</span>
<span class="nx">g</span><span class="p">.</span><span class="nx">position</span><span class="p">[</span><span class="mi">1</span><span class="p">]</span> <span class="o">=</span> <span class="mi">100</span><span class="p">;</span>
<span class="nx">g</span><span class="p">.</span><span class="nx">add</span><span class="p">(</span><span class="k">new</span> <span class="nx">Gdraw</span><span class="p">.</span><span class="nx">Circle</span><span class="p">({</span>
    <span class="na">style</span><span class="p">:</span> <span class="p">{</span>
        <span class="na">x</span><span class="p">:</span> <span class="mi">100</span><span class="p">,</span>
        <span class="na">y</span><span class="p">:</span> <span class="mi">100</span><span class="p">,</span>
        <span class="na">r</span><span class="p">:</span> <span class="mi">20</span><span class="p">,</span>
    <span class="p">}</span>
<span class="p">}));</span>
<span class="nx">zr</span><span class="p">.</span><span class="nx">add</span><span class="p">(</span><span class="nx">g</span><span class="p">);</span>
</code></pre>
          </div>

          <h3 id="Gdrawgroupaddchild">Gdraw.Group.add(child)</h3>

          <p>添加子节点到最后。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>child</td>
              <td><a href="#Gdrawelement"><code class="highlighter-rouge">Element</code></a></td>
              <td> </td>
              <td>待添加的元素。</td>
            </tr>
            </tbody>
          </table>

          <h3 >返回值</h3>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawgroupaddbeforechild-nextsibling">Gdraw.Group.addBefore</a>、<a href="#Gdrawgroupremovechild">Gdraw.Group.remove</a>。</p>

          <h3 id="Gdrawgroupaddbeforechild-nextsibling">Gdraw.Group.addBefore(child, nextSibling)</h3>

          <p>添加子节点到 <code class="highlighter-rouge">nextSibling</code> 之前。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>child</td>
              <td><a href="#Gdrawelement"><code class="highlighter-rouge">Element</code></a></td>
              <td> </td>
              <td>待添加的元素。</td>
            </tr>
            <tr>
              <td>nextSibling</td>
              <td><a href="#Gdrawelement"><code class="highlighter-rouge">Element</code></a></td>
              <td> </td>
              <td>已经在 Group 中的元素。</td>
            </tr>
            </tbody>
          </table>

          <h3 >返回值</h3>

          <p><code class="highlighter-rouge">this</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawgroupaddchild">Gdraw.Group.add</a>、<a href="#Gdrawgroupremovechild">Gdraw.Group.remove</a>。</p>

          <h3 id="Gdrawgroupchildatidx">Gdraw.Group.childAt(idx)</h3>

          <p>返回特定序号的子元素，类型：<a href="#Gdrawelement"><code class="highlighter-rouge">Element</code></a>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawgroupchildofname">Gdraw.Group.childOfName</a>、 <a href="#Gdrawgroupchildren">Gdraw.Group.children</a>。</p>

          <h3 id="Gdrawgroupchildcount">Gdraw.Group.childCount()</h3>

          <p>返回子元素个数，类型：<code class="highlighter-rouge">number</code>。</p>

          <h3 id="Gdrawgroupchildofnamename">Gdraw.Group.childOfName(name)</h3>

          <p>返回特定名字的子元素，类型：<a href="#Gdrawelement"><code class="highlighter-rouge">Element</code></a>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawgroupchildatidx">Gdraw.Group.childAt</a>、 <a href="#Gdrawgroupchildren">Gdraw.Group.children</a>。</p>

          <h3 id="Gdrawgroupchildren">Gdraw.Group.children()</h3>

          <p>返回所有子元素，类型：<a href="#Gdrawelement"><code class="highlighter-rouge">Element[]</code></a>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawgroupchildatidx">Gdraw.Group.childAt</a>、 <a href="#Gdrawgroupchildofname">Gdraw.Group.childOfName</a>。</p>

          <h3 id="Gdrawgroupdirty">Gdraw.Group.dirty()</h3>

          <p>将组设为需要更新。</p>

          <h3 id="Gdrawgroupeachchildcb-context">Gdraw.Group.eachChild(cb, context)</h3>

          <p>遍历所有子节点。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>回调函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>执行回调函数的上下文。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawgroupgetboundingrectincludechildren">Gdraw.Group.getBoundingRect(includeChildren)</h3>

          <p>得到 <code class="highlighter-rouge">includeChildren</code> 或组内所有元素的包围盒。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>includeChildren</td>
              <td><a href="#Gdrawelement"><code class="highlighter-rouge">Gdraw.Element[]</code></a></td>
              <td> </td>
              <td>组内元素的子集。如果 <code class="highlighter-rouge">includeChildren</code> 未设置，则获取所有元素的包围盒，否则获得 <code class="highlighter-rouge">includeChildren</code> 的包围盒。</td>
            </tr>
            </tbody>
          </table>

          <h3 >返回值</h3>

          <p><code class="highlighter-rouge">includeChildren</code> 或组内所有元素的包围盒，类型：<a href="#Gdrawboundingrect"><code class="highlighter-rouge">Gdraw.BoundingRect</code></a>。</p>

          <h3 id="Gdrawgroupremovechild">Gdraw.Group.remove(child)</h3>

          <p>移除子节点。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>child</td>
              <td><a href="#Gdrawelement"><code class="highlighter-rouge">Gdraw.Element</code></a></td>
              <td> </td>
              <td>待移除的元素。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#Gdrawgroupaddchild">Gdraw.Group.add</a>、 <a href="#Gdrawgroupremoveall">Gdraw.Group.removeAll</a>。</p>

          <h3 id="Gdrawgroupremoveall">Gdraw.Group.removeAll()</h3>

          <p>移除所有子节点。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawgroupaddchild">Gdraw.Group.add</a>、 <a href="#Gdrawgroupremove">Gdraw.Group.remove</a>。</p>

          <h3 id="Gdrawgroupsilent">Gdraw.Group.silent</h3>

          <p>类型：<code class="highlighter-rouge">boolean</code>，默认值：<code class="highlighter-rouge">false</code>，所有子孙元素是否响应鼠标事件。</p>


          <h3 id="Gdrawlineargradient">Gdraw.LinearGradient</h3>

          <p><strong>继承自 <a href="#Gdrawgradient">Gdraw.Gradient</a></strong></p>

          <p>线性渐变。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.LinearGradient(x, y, x2, y2, colorStops, globalCoord)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>渐变起始位置横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>渐变起始位置纵坐标。</td>
            </tr>
            <tr>
              <td>x2</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">1</code></td>
              <td>渐变终止位置横坐标。</td>
            </tr>
            <tr>
              <td>y2</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">1</code></td>
              <td>渐变终止位置纵坐标。</td>
            </tr>
            <tr>
              <td>colorStops</td>
              <td><code class="highlighter-rouge">Object[]</code></td>
              <td> </td>
              <td>组成渐变色的颜色。每个颜色包括 <code class="highlighter-rouge">offset</code> 与 <code class="highlighter-rouge">color</code> 属性，前者表示渐变位置（类型：<code class="highlighter-rouge">number</code>），后者表示具体的颜色（类型：<code class="highlighter-rouge">string</code>）</td>
            </tr>
            <tr>
              <td>globalCoord</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>如果为 <code class="highlighter-rouge">false</code>，则 <code class="highlighter-rouge">colorStops</code> 取值范围是 <code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">1</code>；如果为 <code class="highlighter-rouge">true</code>，则 <code class="highlighter-rouge">x</code>、 <code class="highlighter-rouge">y</code>、 <code class="highlighter-rouge">x2</code>、 <code class="highlighter-rouge">y2</code>、 <code class="highlighter-rouge">colorStops</code> 的坐标和元素是一致的（也就是说，原先用 <code class="highlighter-rouge">1</code> 表示物体最右侧，这时需要用元素实际宽度表示最右侧）。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawmatrix">Gdraw.matrix</h3>

          <p><strong>静态属性</strong></p>

          <p>矩阵工具，<code class="highlighter-rouge">3x2</code> 的矩阵，用以表示二维物体的位移、旋转、缩放。</p>

          <blockquote>
            <p>用长度为 <code class="highlighter-rouge">6</code> 的数组表示矩阵。如果浏览器不支持 <code class="highlighter-rouge">Float32Array</code> 则类型为 <code class="highlighter-rouge">number[]</code>，否则为 <code class="highlighter-rouge">Float32Array</code>。</p>
          </blockquote>

          <h3 id="Gdrawmatrixcopyout-m">Gdraw.matrix.copy(out, m)</h3>

          <p>将矩阵 <code class="highlighter-rouge">m</code> 复制给矩阵 <code class="highlighter-rouge">out</code>。不会创建新矩阵，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的矩阵，由 <a href="#Gdrawmatrixcreate"><code class="highlighter-rouge">Gdraw.matrix.create</code></a> 创建。</td>
            </tr>
            <tr>
              <td>m</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>参考矩阵。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>修改后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawmatrixcreate">Gdraw.matrix.create()</h3>

          <p>创建一个单位矩阵。</p>

          <h4 >返回值</h4>

          <p>新创建的单位矩阵，类型：<code class="highlighter-rouge">Float32Array|number[]</code>，元素个数为 <code class="highlighter-rouge">6</code>。</p>

          <h3 id="Gdrawmatrixidentityout">Gdraw.matrix.identity(out)</h3>

          <p>将 <code class="highlighter-rouge">out</code> 设为单位矩阵，也就是 <code class="highlighter-rouge">[1, 0, 0, 1, 0, 0]</code>。不会创建新矩阵，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的矩阵，由 <a href="#Gdrawmatrixcreate"><code class="highlighter-rouge">Gdraw.matrix.create</code></a> 创建。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>修改后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawmatrixinvertout-m">Gdraw.matrix.invert(out, m)</h3>

          <p>求到矩阵 <code class="highlighter-rouge">m</code> 的逆矩阵，得到的结果赋值给 <code class="highlighter-rouge">out</code>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出矩阵，由 <a href="#Gdrawmatrixcreate"><code class="highlighter-rouge">Gdraw.matrix.create</code></a> 创建。</td>
            </tr>
            <tr>
              <td>m</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待求逆的矩阵，不会在改方法中被改变。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>修改后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawmatrixmulout-m1-m2">Gdraw.matrix.mul(out, m1, m2)</h3>

          <p>将矩阵 <code class="highlighter-rouge">m1</code> 与 <code class="highlighter-rouge">m2</code> 相乘，得到的结果赋值给 <code class="highlighter-rouge">out</code>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出矩阵，由 <a href="#Gdrawmatrixcreate"><code class="highlighter-rouge">Gdraw.matrix.create</code></a> 创建。</td>
            </tr>
            <tr>
              <td>m1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待相乘的矩阵。</td>
            </tr>
            <tr>
              <td>m2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待相乘的矩阵。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>修改后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawmatrixrotateout-m-rad">Gdraw.matrix.rotate(out, m, rad)</h3>

          <p>将矩阵 <code class="highlighter-rouge">m</code> 旋转 <code class="highlighter-rouge">rad</code> 弧度，得到的结果赋值给 <code class="highlighter-rouge">out</code>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出矩阵，由 <a href="#Gdrawmatrixcreate"><code class="highlighter-rouge">Gdraw.matrix.create</code></a> 创建。</td>
            </tr>
            <tr>
              <td>m</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的矩阵，不会在改方法中被改变。</td>
            </tr>
            <tr>
              <td>rad</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>旋转弧度。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>修改后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawmatrixscaleout-m-v">Gdraw.matrix.scale(out, m, v)</h3>

          <p>将矩阵 <code class="highlighter-rouge">m</code> 沿向量 <code class="highlighter-rouge">v</code> 缩放，得到的结果赋值给 <code class="highlighter-rouge">out</code>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出矩阵，由 <a href="#Gdrawmatrixcreate"><code class="highlighter-rouge">Gdraw.matrix.create</code></a> 创建。</td>
            </tr>
            <tr>
              <td>m</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的矩阵，不会在改方法中被改变。</td>
            </tr>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>长度为 <code class="highlighter-rouge">2</code> 的缩放向量，表示横向和纵向的缩放量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>修改后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawmatrixtranslateout-m-v">Gdraw.matrix.translate(out, m, v)</h3>

          <p>将矩阵 <code class="highlighter-rouge">m</code> 沿向量 <code class="highlighter-rouge">v</code> 平移，得到的结果赋值给 <code class="highlighter-rouge">out</code>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出矩阵，由 <a href="#Gdrawmatrixcreate"><code class="highlighter-rouge">Gdraw.matrix.create</code></a> 创建。</td>
            </tr>
            <tr>
              <td>m</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的矩阵，不会在改方法中被改变。</td>
            </tr>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>长度为 <code class="highlighter-rouge">2</code> 的平移向量，表示横向和纵向的偏移量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>修改后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>


          <h3 id="Gdraw-path">Gdraw.path</h3>

          <p><strong>静态属性</strong></p>

          <p>路径相关的辅助函数。</p>

          <h3 id="Gdrawpathcreatefromstringstr-opts">Gdraw.path.createFromString(str, opts)</h3>

          <p>从字符串创建路径，字符串形如 <a href="http://www.w3.org/TR/SVG/paths.html#PathData">SVG Path</a>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>str</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>构建路径的字符串。</td>
            </tr>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a> 的配置项。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawpathextendfromstringstr-opts">Gdraw.path.extendFromString(str, opts)</h3>

          <p>从字符串扩展路径，字符串形如 <a href="http://www.w3.org/TR/SVG/paths.html#PathData">SVG Path</a>。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>str</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td> </td>
              <td>扩展路径的字符串。</td>
            </tr>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a> 的配置项。</td>
            </tr>
            </tbody>
          </table>

          <h4 >相关</h4>

          <p><a href="#Gdrawpathextendprops">Gdraw.Path.extend</a>。</p>

          <h3 id="Gdrawpathmergepathpathels-opts">Gdraw.path.mergePath(pathEls, opts)</h3>

          <p>合并多条路径。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>pathEls</td>
              <td><a href="#Gdrawpath"><code class="highlighter-rouge">Path[]</code></a></td>
              <td> </td>
              <td>路径数组。</td>
            </tr>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项，参见 <a href="#Gdrawdisplayable">Gdraw.Displayable</a> 的配置项。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawpattern">Gdraw.Pattern</h3>

          <p>图案。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Pattern(image, repeat)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>image</td>
              <td><code class="highlighter-rouge">HTMLImageElement</code></td>
              <td> </td>
              <td>图片对象。</td>
            </tr>
            <tr>
              <td>repeat</td>
              <td><code class="highlighter-rouge">string</code></td>
              <td><code class="highlighter-rouge">'repeat'</code></td>
              <td>重复模式，可取值有：<code class="highlighter-rouge">'repeat'</code>、 <code class="highlighter-rouge">'repeat-x'</code>、 <code class="highlighter-rouge">'repeat-y'</code>、 <code class="highlighter-rouge">'no-repeat'</code>。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawradialgradient">Gdraw.RadialGradient</h3>

          <p><strong>继承自 <a href="#Gdrawgradient">Gdraw.Gradient</a></strong></p>

          <p>径向渐变。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.RadialGradient(x, y, r, colorStops, globalCoord)</code></p>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0.5</code></td>
              <td>渐变中心位置横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0.5</code></td>
              <td>渐变中心位置纵坐标。</td>
            </tr>
            <tr>
              <td>r</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0.5</code></td>
              <td>渐变半径。</td>
            </tr>
            <tr>
              <td>colorStops</td>
              <td><code class="highlighter-rouge">Object[]</code></td>
              <td> </td>
              <td>组成渐变色的颜色。每个颜色包括 <code class="highlighter-rouge">offset</code> 与 <code class="highlighter-rouge">color</code> 属性，前者表示渐变位置（类型：<code class="highlighter-rouge">number</code>），后者表示具体的颜色（类型：<code class="highlighter-rouge">string</code>）</td>
            </tr>
            <tr>
              <td>globalCoord</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>如果为 <code class="highlighter-rouge">false</code>，则 <code class="highlighter-rouge">colorStops</code> 取值范围是 <code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">1</code>；如果为 <code class="highlighter-rouge">true</code>，则 <code class="highlighter-rouge">x</code>、 <code class="highlighter-rouge">y</code>、 <code class="highlighter-rouge">r</code>、 <code class="highlighter-rouge">colorStops</code> 的坐标和元素是一致的（也就是说，原先用 <code class="highlighter-rouge">1</code> 表示物体最右侧，这时需要用元素实际宽度表示最右侧）。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawtransformable">Gdraw.Transformable</h3>

          <p>可进行变换的对象，变换包括：位移、旋转、缩放。</p>

          <h4 >构造函数</h4>

          <p><code class="highlighter-rouge">Gdraw.Transformable(opts)</code></p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>opts</td>
              <td><code class="highlighter-rouge">Object</code></td>
              <td> </td>
              <td>配置项。</td>
            </tr>
            <tr>
              <td>opts.position</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td><code class="highlighter-rouge">[0, 0]</code></td>
              <td>位移。</td>
            </tr>
            <tr>
              <td>opts.rotation</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td><code class="highlighter-rouge">0</code></td>
              <td>旋转的弧度。</td>
            </tr>
            <tr>
              <td>opts.scale</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td><code class="highlighter-rouge">[1, 1]</code></td>
              <td>缩放。</td>
            </tr>
            <tr>
              <td>opts.origin</td>
              <td><code class="highlighter-rouge">number[]</code></td>
              <td><code class="highlighter-rouge">null</code></td>
              <td>旋转和缩放的原点。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawtransformabledecomposetransform">Gdraw.Transformable.decomposeTransform()</h3>

          <p>分解 <code class="highlighter-rouge">transform</code> 矩阵到 <code class="highlighter-rouge">position</code>、 <code class="highlighter-rouge">rotation</code>、 <code class="highlighter-rouge">scale</code>。通常用于修改 <code class="highlighter-rouge">transform</code> 后同步<code class="highlighter-rouge">position</code>、 <code class="highlighter-rouge">rotation</code>、 <code class="highlighter-rouge">scale</code> 属性。</p>

          <h3 id="Gdrawtransformablegetglobalscale">Gdraw.Transformable.getGlobalScale()</h3>

          <p>获得全局的缩放。也就是说会祖先元素的缩放也会计算在内。</p>

          <h4 >返回值</h4>

          <p>缩放，类型： <code class="highlighter-rouge">number[]</code>。</p>

          <h3 id="Gdrawtransformableorigin">Gdraw.Transformable.origin</h3>

          <p>旋转和缩放的原点，类型： <code class="highlighter-rouge">number[]</code>。</p>

          <h3 id="Gdrawtransformableposition">Gdraw.Transformable.position</h3>

          <p>位移，类型： <code class="highlighter-rouge">number[]</code>。</p>

          <h3 id="Gdrawtransformablerotation">Gdraw.Transformable.rotation</h3>

          <p>旋转的弧度，类型： <code class="highlighter-rouge">number</code>。</p>

          <h3 id="Gdrawtransformablescale">Gdraw.Transformable.scale</h3>

          <p>缩放，类型： <code class="highlighter-rouge">number[]</code>。</p>

          <h3 id="Gdrawtransformabletransform">Gdraw.Transformable.transform</h3>

          <p>矩阵形式表示位移、旋转、缩放，类型： <a href="#Gdrawmatrix"><code class="highlighter-rouge">Gdraw.matrix</code></a>。</p>

          <h3 id="Gdrawtransformabletransformcoordtoglobalx-y">Gdraw.Transformable.transformCoordToGlobal(x, y)</h3>

          <p>变换局部坐标位置到全局坐标空间。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>纵坐标。</td>
            </tr>
            </tbody>
          </table>

          <h3 id="Gdrawtransformabletransformcoordtolocalx-y">Gdraw.Transformable.transformCoordToLocal(x, y)</h3>

          <p>变换坐标位置到元素的局部坐标空间。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>x</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>横坐标。</td>
            </tr>
            <tr>
              <td>y</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>纵坐标。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutil">Gdraw.util</h3>

          <p><strong>静态属性</strong></p>

          <p>常用辅助函数。</p>


          <h3 id="Gdrawutilbindfunc-context">Gdraw.util.bind(func, context)</h3>

          <p>修改执行上下文。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>func</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>待执行的函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutilclonesource">Gdraw.util.clone(source)</h3>

          <p>深度拷贝一个对象。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>source</td>
              <td><code class="highlighter-rouge">Object|Array|TypedArray|number|string|null|undefined</code></td>
              <td> </td>
              <td>参考对象。如果是 <code class="highlighter-rouge">Object</code> 类型，则克隆的结果是不包含原型属性的纯对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>克隆结果，类型：<code class="highlighter-rouge">Object|Array|TypedArray|number|string|null|undefined</code>。</p>


          <h3 id="Gdrawutilcreatecanvas">Gdraw.util.createCanvas()</h3>

          <p>获得一个 Canvas，不设置宽高。相当于 <code class="highlighter-rouge">document.createElement('canvas')</code>。</p>

          <h4 >返回值</h4>

          <p>Canvas，类型：<code class="highlighter-rouge">HTMLCanvasElement</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawutilgetcontext">Gdraw.util.getContext</a>。</p>


          <h3 id="Gdrawutilcurryfunc">Gdraw.util.curry(func)</h3>

          <p>函数柯里化。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>func</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>回调函数。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutildefaultstarget-source-overlay">Gdraw.util.defaults(target, source, overlay)</h3>

          <p>将一个对象中的元素赋给另一个元素。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>target</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>需要修改的对象。</td>
            </tr>
            <tr>
              <td>source</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>参考对象。</td>
            </tr>
            <tr>
              <td>overlay</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td> </td>
              <td>如果 <code class="highlighter-rouge">overlay</code> 为 <code class="highlighter-rouge">true</code>，则将 <code class="highlighter-rouge">source</code> 中非空的属性赋给 <code class="highlighter-rouge">targe</code>；如果 <code class="highlighter-rouge">overlay</code> 为 <code class="highlighter-rouge">false</code>，则将 <code class="highlighter-rouge">source</code> 中 <code class="highlighter-rouge">target</code> 不包含的属性赋给 <code class="highlighter-rouge">targe</code>。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>拷贝结果，即 <code class="highlighter-rouge">target</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawutilmixintarget-source-overlay">Gdraw.util.mixin</a>。</p>


          <h3 id="Gdrawutileacharray-cb-context">Gdraw.util.each(array, cb, context)</h3>

          <p>遍历数组。相当于 <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/forEach">Array.prototype.forEach</a>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>遍历回调函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutilextendtarget-source">Gdraw.util.extend(target, source)</h3>

          <p>将 <code class="highlighter-rouge">source</code> 中非继承来的属性赋给 <code class="highlighter-rouge">target</code>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>target</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>需要修改的对象。</td>
            </tr>
            <tr>
              <td>source</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>参考对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>拷贝结果，即 <code class="highlighter-rouge">target</code>。</p>


          <h3 id="Gdrawutilfilterarray-cb-context">Gdraw.util.filter(array, cb, context)</h3>

          <p>过滤元素。相当于 <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter">Array.prototype.filter</a>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>回调函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutilfindarray-cb-context">Gdraw.util.find(array, cb, context)</h3>

          <p>相当于 <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/find">Array.prototype.find</a>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>用以检查元素是否存在的函数，返回元素是否存在的 <code class="highlighter-rouge">boolean</code> 结果。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>返回数组 <code class="highlighter-rouge">array</code> 中第一个找到的元素，类型：<code class="highlighter-rouge">*</code>。</p>


          <h3 id="Gdrawutilgetcontext">Gdraw.util.getContext()</h3>

          <p>获得一个 Canvas 的绘制上下文。相当于 <code class="highlighter-rouge">document.createElement('canvas').getContext('2d')</code>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>用以检查元素是否存在的函数，返回元素是否存在的 <code class="highlighter-rouge">boolean</code> 结果。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>Canvas 的绘制上下文，类型：<code class="highlighter-rouge">CanvasRenderingContext2D</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawutilcreatecanvas">Gdraw.util.createCanvas</a>。</p>


          <h3 id="Gdrawutilindexofarray-value">Gdraw.util.indexOf(array, value)</h3>

          <p>查询数组中元素，返回下标。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>value</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>寻找的对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>下标，类型：<code class="highlighter-rouge">number</code>。</p>


          <h3 id="Gdrawutilinheritsclazz-baseclazz">Gdraw.util.inherits(clazz, baseClazz)</h3>

          <p>继承一个类，<code class="highlighter-rouge">baseClazz</code> 会继承 <code class="highlighter-rouge">clazz</code> 的方法、属性，<code class="highlighter-rouge">clazz</code> 会有 <code class="highlighter-rouge">superClass</code> 属性，指向 <code class="highlighter-rouge">baseClazz</code>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>clazz</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>基类。</td>
            </tr>
            <tr>
              <td>baseClazz</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>子类。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutilisarraydata">Gdraw.util.isArray(data)</h3>

          <p>是否是数组。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>data</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>判断对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>是否是数组，类型：<code class="highlighter-rouge">boolean</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawutilisarraylikedata">Gdraw.util.isArrayLike</a>。</p>


          <h3 id="Gdrawutilisfunctiondata">Gdraw.util.isFunction(data)</h3>

          <p>是否是函数。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>data</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>判断对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>是否是函数，类型：<code class="highlighter-rouge">boolean</code>。</p>


          <h3 id="Gdrawutilisobjectdata">Gdraw.util.isObject(data)</h3>

          <p>是否是对象。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>data</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>判断对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>是否是对象，类型：<code class="highlighter-rouge">boolean</code>。</p>


          <h3 id="Gdrawutilisstringdata">Gdraw.util.isString(data)</h3>

          <p>是否是字符串。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>data</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>判断对象。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>是否是字符串，类型：<code class="highlighter-rouge">boolean</code>。</p>


          <h3 id="Gdrawutilmaparray-cb-context">Gdraw.util.map(array, cb, context)</h3>

          <p>映射数组。相当于 <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map">Array.prototype.map</a>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>映射函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutilmergetarget-source-overwrite">Gdraw.util.merge(target, source, overwrite)</h3>

          <p>拷贝一个对象。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>target</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>需要修改的对象。</td>
            </tr>
            <tr>
              <td>source</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>参考对象。</td>
            </tr>
            <tr>
              <td>overwrite</td>
              <td><code class="highlighter-rouge">boolean</code></td>
              <td><code class="highlighter-rouge">false</code></td>
              <td>是否深度拷贝。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>拷贝结果，即 <code class="highlighter-rouge">target</code>。</p>


          <h3 id="Gdrawutilreducearray-cb-context">Gdraw.util.reduce(array, cb, context)</h3>

          <p>相当于 <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/reduce">Array.prototype.reduce</a>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>cb</td>
              <td><code class="highlighter-rouge">Function</code></td>
              <td> </td>
              <td>回调函数。</td>
            </tr>
            <tr>
              <td>context</td>
              <td><code class="highlighter-rouge">*</code></td>
              <td> </td>
              <td>执行上下文。</td>
            </tr>
            </tbody>
          </table>


          <h3 id="Gdrawutilslicearray-start-end">Gdraw.util.slice(array, start, end)</h3>

          <p>相当于 <a href="https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/slice">Array.prototype.slice</a>。</p>

          <h4 >参数</h4>

          <table>
            <tbody>
            <tr>
              <td>名称</td>
              <td>类型</td>
              <td>默认值</td>
              <td>描述</td>
            </tr>
            <tr>
              <td>array</td>
              <td><code class="highlighter-rouge">[]</code></td>
              <td> </td>
              <td>数组。</td>
            </tr>
            <tr>
              <td>start</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>起始下标。</td>
            </tr>
            <tr>
              <td>end</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>终止下标。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>数组 <code class="highlighter-rouge">array</code> 在 <code class="highlighter-rouge">start</code>（包含）位置到 <code class="highlighter-rouge">end</code>（不包含）位置的浅拷贝数组，类型：<code class="highlighter-rouge">[]</code>。</p>


          <h3 id="Gdrawvector">Gdraw.vector</h3>

          <p><strong>静态属性</strong></p>

          <p>长度为 <code class="highlighter-rouge">2</code> 的向量。</p>

          <blockquote>
            <p>如果浏览器不支持 <code class="highlighter-rouge">Float32Array</code> 则类型为 <code class="highlighter-rouge">number[]</code>，否则为 <code class="highlighter-rouge">Float32Array</code>。</p>
          </blockquote>

          <h3 id="Gdrawvectoraddout-v1-v2">Gdraw.vector.add(out, v1, v2)</h3>

          <p>将向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 相加，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawvectorscaleandaddout-v1-v2-scale">Gdraw.vector.scaleAndAdd</a>。</p>

          <h3 id="Gdrawvectorapplytransformout-v-m">Gdraw.vector.applyTransform(out, v, m)</h3>

          <p>矩阵 <code class="highlighter-rouge">m</code> 左乘向量 <code class="highlighter-rouge">v</code>，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>向量。</td>
            </tr>
            <tr>
              <td>m</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>矩阵，参见 <a href="#Gdrawmatrix">Gdraw.matrix</a>。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectorcopyout-v">Gdraw.vector.copy(out, v)</h3>

          <p>将向量 <code class="highlighter-rouge">v</code> 复制给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的向量。</td>
            </tr>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>参考向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectorclonev">Gdraw.vector.clone(v)</h3>

          <p>将向量 <code class="highlighter-rouge">v</code> 复制，产生一个新副本。</p>

          <h4 >返回值</h4>

          <p>新创建的向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectordistancev1-v2">Gdraw.vector.distance(v1, v2)</h3>

          <p>得到向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 间距离。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>距离，类型：<code class="highlighter-rouge">number</code>。</p>

          <h3 id="Gdrawvectordistancesquarev1-v2">Gdraw.vector.distanceSquare(v1, v2)</h3>

          <p>得到向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 间距离的平方。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>距离的平方，类型：<code class="highlighter-rouge">number</code>。</p>

          <h3 id="Gdrawvectordivout-v1-v2">Gdraw.vector.div(out, v1, v2)</h3>

          <p>将向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 的每个元素分别相除，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectordotv1-v2">Gdraw.vector.dot(v1, v2)</h3>

          <p>将向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 点乘，返回点积。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>点积，类型：<code class="highlighter-rouge">number</code>。</p>

          <h3 id="Gdrawvectorlenv">Gdraw.vector.len(v)</h3>

          <p>求向量 <code class="highlighter-rouge">v</code> 的模长，也就是其两个元素的几何平均数。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待求模长的向量，不会在该方法中被改变。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>模长，类型：<code class="highlighter-rouge">number</code>。</p>

          <h3 id="Gdrawvectorlensquarev">Gdraw.vector.lenSquare(v)</h3>

          <p>求向量 <code class="highlighter-rouge">v</code> 的模长的平方。</p>

          <h4 >参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待求模长平方的向量，不会在该方法中被改变。</td>
            </tr>
            </tbody>
          </table>

          <h4 >返回值</h4>

          <p>模长平方，类型：<code class="highlighter-rouge">number</code>。</p>

          <h3 id="Gdrawvectorlerpout-v1-v2-t">Gdraw.vector.lerp(out, v1, v2, t)</h3>

          <p>将向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 在 <code class="highlighter-rouge">t</code> 位置进行插值，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 id="参数-9">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            <tr>
              <td>t</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>位置，<code class="highlighter-rouge">0</code> 到 <code class="highlighter-rouge">1</code>，<code class="highlighter-rouge">1</code> 表示 <code class="highlighter-rouge">v2</code> 处。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-10">返回值</h4>

          <p>插值后的向量 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectormaxout-v1-v2">Gdraw.vector.max(out, v1, v2)</h3>

          <p>求两个向量每个元素的最大值，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 id="参数-10">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-11">返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawvectorminout-v1-v2">Gdraw.vector.min</a>。</p>

          <h3 id="Gdrawvectorminout-v1-v2">Gdraw.vector.min(out, v1, v2)</h3>

          <p>求两个向量每个元素的最小值，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 id="参数-11">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-12">返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectormulout-v1-v2">Gdraw.vector.mul(out, v1, v2)</h3>

          <p>将向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 相乘，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 id="参数-12">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-13">返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectornegateout-v">Gdraw.vector.negate(out, v)</h3>

          <p>将向量 <code class="highlighter-rouge">v</code> 的负向量输出到 <code class="highlighter-rouge">out</code>，也就是每个元素都变成相反数。</p>

          <h4 id="参数-13">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输入向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-14">返回值</h4>

          <p>负向量 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectornormalizeout-v">Gdraw.vector.normalize(out, v)</h3>

          <p>将向量 <code class="highlighter-rouge">v</code> 归一化输出到 <code class="highlighter-rouge">out</code>，也就是将其模长变为 <code class="highlighter-rouge">1</code>。</p>

          <h4 id="参数-14">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输入向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-15">返回值</h4>

          <p>归一化后的 <code class="highlighter-rouge">out</code>，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectorscaleout-v-s">Gdraw.vector.scale(out, v, s)</h3>

          <p>将向量 <code class="highlighter-rouge">v</code> 缩放 <code class="highlighter-rouge">s</code> 倍，得到的结果赋值给 <code class="highlighter-rouge">out</code>。</p>

          <h4 id="参数-15">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的向量，不会在改方法中被改变。</td>
            </tr>
            <tr>
              <td>s</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>缩放量。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-16">返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawvectorscaleandaddout-v1-v2-scale">Gdraw.vector.scaleAndAdd</a>。</p>

          <h3 id="Gdrawvectorscaleandaddout-v1-v2-scale">Gdraw.vector.scaleAndAdd(out, v1, v2, scale)</h3>

          <p>将向量 <code class="highlighter-rouge">v2</code> 缩放 <code class="highlighter-rouge">scale</code> 倍后，与 <code class="highlighter-rouge">v1</code> 相加，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 id="参数-16">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            <tr>
              <td>scale</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>缩放比例，<code class="highlighter-rouge">1</code> 表示不缩放。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-17">返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h4 >相关</h4>

          <p><a href="#Gdrawvectoraddout-v1-v2">Gdraw.vector.add</a>、<a href="#Gdrawvectorscaleout-v-s">Gdraw.vector.scale</a>。</p>

          <h3 id="Gdrawvectorsetout-a-b">Gdraw.vector.set(out, a, b)</h3>

          <p>将值 <code class="highlighter-rouge">(a, b)</code> 赋给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 id="参数-17">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>待修改的向量。</td>
            </tr>
            <tr>
              <td>a</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>向量的第一个维度。</td>
            </tr>
            <tr>
              <td>b</td>
              <td><code class="highlighter-rouge">number</code></td>
              <td> </td>
              <td>向量的第二个维度。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-18">返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>

          <h3 id="Gdrawvectorsubout-v1-v2">Gdraw.vector.sub(out, v1, v2)</h3>

          <p>将向量 <code class="highlighter-rouge">v1</code> 与 <code class="highlighter-rouge">v2</code> 相减，赋值给向量 <code class="highlighter-rouge">out</code>。不会创建新向量，而是将 <code class="highlighter-rouge">out</code> 的元素进行改变。</p>

          <h4 id="参数-18">参数</h4>

          <table>
            <thead>
            <tr>
              <th>名称</th>
              <th>类型</th>
              <th>默认值</th>
              <th>描述</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>out</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>输出向量。</td>
            </tr>
            <tr>
              <td>v1</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第一个向量。</td>
            </tr>
            <tr>
              <td>v2</td>
              <td><code class="highlighter-rouge">Float32Array|number[]</code></td>
              <td> </td>
              <td>第二个向量。</td>
            </tr>
            </tbody>
          </table>

          <h4 id="返回值-19">返回值</h4>

          <p>输出向量，类型：<code class="highlighter-rouge">Float32Array|number[]</code>。</p>


        </div>
      </div>
    </el-scrollbar>
  </div>
</template>

<script>
  export default {
    name: "api",
    data() {
      return {}
    },
    components: {},
    computed: {},
    methods: {},
    created() {

    },
    mounted() {

    }
  }

</script>

<style scoped lang="scss" rel="stylesheet/scss">
  @import "../../../../assets/classLib/gdraw/api";
  #api{
    width: 100%;
    /*height: calc(100% - 50px);*/
    background-color: #ecefff;
    /*padding-top: 20px;*/
  }
  .sidebar{
    left: 170px;
  }
</style>
