import Path from '../Path'
import ObjUtil from '../../../../utilLib/Obj'
/**
 * @Author DingJianFei
 * @Date 2019/5/26
 * @Description: 箭头图形
*/
export default class extends Path {
	constructor(opt) {
		let param = {
			shape: {
				x1: 0,
				y1: 0,
				x2: 0,
				y2: 0,
				breakPoints:null,
				arrowLength:15,
				arrowAngle:20,
				arrowType:'hollow' //hollow,solid
			},

			style: {
				stroke: '#000',
				fill: null
			},

		}
		ObjUtil.deepMix(param, opt)
		super(param);

	}
	type='arrow';
	buildPath(ctx, shape) {
		let arrowAngle = shape.arrowAngle,
			arrowLength = shape.arrowLength,
			x1 = shape.x1,
			y1 = shape.y1,
			x2 = shape.x2,
			y2 = shape.y2,
			arrowType=shape.arrowType,
			angle = shape.breakPoints&&shape.breakPoints.length>0?Math.atan2(shape.breakPoints[shape.breakPoints.length-1][1] - y2, shape.breakPoints[shape.breakPoints.length-1][0] - x2) * 180 / Math.PI : Math.atan2(y1 - y2, x1 - x2) * 180 / Math.PI,
			angle1 = (angle + arrowAngle) * Math.PI / 180,
			angle2 = (angle - arrowAngle) * Math.PI / 180,
			topX = arrowLength * Math.cos(angle1),
			topY = arrowLength * Math.sin(angle1),
			botX = arrowLength * Math.cos(angle2),
			botY = arrowLength * Math.sin(angle2);

		let arrowX1 = x2 + topX, //终点箭头
			arrowY1 = y2 + topY;
		ctx.moveTo(arrowX1, arrowY1);
		ctx.lineTo(x2, y2);
		let arrowX2 = x2 + botX,
		arrowY2 = y2 + botY;
		ctx.lineTo(arrowX2, arrowY2);

		if(arrowType=='solid'){
			ctx.lineTo(arrowX1, arrowY1);
			let toX1=(arrowX2+arrowX1)/2;
			let toY2=(arrowY1+arrowY2)/2;
			ctx.moveTo(x1, y1);
			if(shape.breakPoints&&shape.breakPoints.length>0){
				for(let v of shape.breakPoints){
					ctx.lineTo(v[0], v[1]);
				}
			}
			ctx.lineTo(toX1, toY2);
		}else{
			// 绘制直线
			ctx.moveTo(x1, y1);
			if(shape.breakPoints&&shape.breakPoints.length>0){
				for(let v of shape.breakPoints){
					ctx.lineTo(v[0], v[1]);
				}
			}
			ctx.lineTo(x2, y2);
		}
		

	}
}


