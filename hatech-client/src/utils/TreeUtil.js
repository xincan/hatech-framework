

  /**
   * 递归组装树状数据结构
   * @param id
   * @param array
   * @return {Array}
   */
  export function getTree(id, array) {
    const items = [];
    for (let obj of array) {
      // 遍历所有节点，将父菜单id与传过来的id比较
      if (obj.parentId === id) {
        items.push(obj);
        if (items.length !== 0) {
          let tree = getTree(obj.id, array);
          if (tree.length > 0) {
            obj.children = tree;
          }
        }
      }
    }
    return items;
  }

