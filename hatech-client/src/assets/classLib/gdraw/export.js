/**
 * @Author DingJianFei
 * @Date 2019/6/21
 * @Description: 统一导出功能类，方便gdraw引入
*/

import * as zrUtil from './renderer/core/util';
import * as matrix from './renderer/core/matrix';
import * as vector from './renderer/core/vector';
import * as colorTool from './renderer/tool/color';
import * as pathTool from './renderer/tool/path';
import {parseSVG} from './renderer/tool/parseSVG';


export {default as Group} from './renderer/container/Group';
export {default as Path} from './renderer/graphic/Path';
export {default as Image} from './renderer/graphic/Image';
export {default as CompoundPath} from './renderer/graphic/CompoundPath';
export {default as Text} from './renderer/graphic/Text';
export {default as IncrementalDisplayable} from './renderer/graphic/IncrementalDisplayable';

export {default as Arc} from './renderer/graphic/shape/Arc';
export {default as BezierCurve} from './renderer/graphic/shape/BezierCurve';
export {default as Circle} from './renderer/graphic/shape/Circle';
export {default as Droplet} from './renderer/graphic/shape/Droplet';
export {default as Ellipse} from './renderer/graphic/shape/Ellipse';
export {default as Heart} from './renderer/graphic/shape/Heart';
export {default as Isogon} from './renderer/graphic/shape/Isogon';
export {default as Line} from './renderer/graphic/shape/Line';
export {default as Polygon} from './renderer/graphic/shape/Polygon';
export {default as Polyline} from './renderer/graphic/shape/Polyline';
export {default as Rect} from './renderer/graphic/shape/Rect';
export {default as Ring} from './renderer/graphic/shape/Ring';
export {default as Rose} from './renderer/graphic/shape/Rose';
export {default as Sector} from './renderer/graphic/shape/Sector';
export {default as Star} from './renderer/graphic/shape/Star';
export {default as Trochoid} from './renderer/graphic/shape/Trochoid';

export {default as LinearGradient} from './renderer/graphic/LinearGradient';
export {default as RadialGradient} from './renderer/graphic/RadialGradient';
export {default as Pattern} from './renderer/graphic/Pattern';
export {default as BoundingRect} from './renderer/core/BoundingRect';

export {matrix};
export {vector};
export {colorTool as color};
export {pathTool as path};
export {zrUtil as util};
export {parseSVG};

export {default as Arrow} from './renderer/graphic/shape/Arrow';
export {default as Link} from './extend/ability/Link';
export {default as Editor} from './extend/ability/Editor';
export {default as ShowEditor} from './extend/ability/ShowEditor';
