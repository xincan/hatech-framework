// TODO Draggable for group
// FIXME Draggable on element which has parent rotation or scale
function Draggable() {

    this.on('mousedown', this._dragStart, this);
    this.on('mousemove', this._drag, this);
    this.on('mouseup', this._dragEnd, this);
    this.on('globalout', this._dragEnd, this);
    // this._dropTarget = null;
    // this._draggingTarget = null;

    // this._x = 0;
    // this._y = 0;
}

Draggable.prototype = {

    constructor: Draggable,

    _dragStart: function (e) {
        var draggingTarget = e.target;
        if (draggingTarget && draggingTarget.draggable&&e.which==1) {
            this._draggingTarget = draggingTarget;
            draggingTarget.dragging = true;
            this._x = e.offsetX;
            this._y = e.offsetY;

            this.dispatchToElement(param(draggingTarget, e), 'dragstart', e.event);
        }
    },

    _drag: function (e) {

        var draggingTarget = this._draggingTarget;
        if (draggingTarget) {
            //获取鼠标当前的位置
            var x = e.offsetX;
            var y = e.offsetY;

            var dx = x - this._x;
            var dy = y - this._y;

            this._x = x;
            this._y = y;

            // 如果是区域元素，判断区域元素的拖拽范围
            if (draggingTarget.isAreaElement) {
              let box = draggingTarget.getBoundingRect();
              let position = draggingTarget.position;
              // 获取移动后的元素的坐标
              let moveX = box.x + position[0];
              let moveY = box.y + position[1];
              if (draggingTarget.areaY[1] - box.height - moveY <= 0) {
                position[1] = position[1] - 1;
                draggingTarget.attr({
                  position:position
                });
              }
              if (draggingTarget.areaY[0] >= moveY) {
                position[1] = position[1] + 1;
                draggingTarget.attr({
                  position:position
                });
              }
              if (draggingTarget.areaY[0] < moveY && draggingTarget.areaY[1] > 0 && draggingTarget.areaY[1] - box.height - moveY > 0) {
                draggingTarget.drift(dx, dy, e);
              }
            } else {
              draggingTarget.drift(dx, dy, e);
            }

            this.dispatchToElement(param(draggingTarget, e), 'drag', e.event);

            var dropTarget = this.findHover(x, y, draggingTarget).target;
            var lastDropTarget = this._dropTarget;
            this._dropTarget = dropTarget;

            if (draggingTarget !== dropTarget) {
                if (lastDropTarget && dropTarget !== lastDropTarget) {
                    this.dispatchToElement(param(lastDropTarget, e), 'dragleave', e.event);
                }
                if (dropTarget && dropTarget !== lastDropTarget) {
                    this.dispatchToElement(param(dropTarget, e), 'dragenter', e.event);
                }
            }
        }
    },

    _dragEnd: function (e) {
        var draggingTarget = this._draggingTarget;

        if (draggingTarget) {
            draggingTarget.dragging = false;
        }

        this.dispatchToElement(param(draggingTarget, e), 'dragend', e.event);

        if (this._dropTarget) {
            this.dispatchToElement(param(this._dropTarget, e), 'drop', e.event);
        }

        this._draggingTarget = null;
        this._dropTarget = null;
    }

};

function param(target, e) {
    return {target: target, topTarget: e && e.topTarget};
}

export default Draggable;
