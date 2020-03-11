/**
 * 多边形
 * @module zrender/shape/Polygon
 */

import Path from '../Path';
import * as polyHelper from '../helper/poly';

export default Path.extend({

    type: 'polygon',

    shape: {
        points: null,

        smooth: false,

        smoothConstraint: null
    },

    buildPath: function (ctx, shape) {
        polyHelper.buildPath(ctx, shape, true);
    },

	isEditable:true,

	changeEditAttr(opts){
		var myRect=this.getBoundingRect();
		if(this.style.lineWidth){
			myRect.x=myRect.x+this.style.lineWidth/2;
			myRect.y=myRect.y+this.style.lineWidth/2
			myRect.width=myRect.width-this.style.lineWidth
			myRect.height=myRect.height-this.style.lineWidth
		}
		if((myRect.width+opts.width)<1){
			opts.x=0;opts.width=0;
		}
		if((myRect.height+opts.height)<1){
			opts.y=0;opts.height=0;
		}

		var k1=(myRect.width+opts.width)/myRect.width;
		var k2=(myRect.height+opts.height)/myRect.height;
		var points=[];
    	for(let v of this.shape.points){
			let x=myRect.x+((v[0]-myRect.x)*k1)+opts.x;
			let y=myRect.y+((v[1]-myRect.y)*k2)+opts.y;
			points.push([x,y])
		}
		var attr={
			shape:{
				points:points
			}
		}
		this.attr(attr)
	}
});
