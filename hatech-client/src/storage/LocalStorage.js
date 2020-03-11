


export default {

  selectJSONArray(key){
      let cell = localStorage.getItem(key), data = [];
      if(cell != undefined){
          cell = JSON.parse(cell);
          cell.forEach(item => {
              data.push(JSON.parse(item));
          });
      }
      console.log("读取", data);
      return data;
  },
  saveJSONArray(key, array){
      let cellHide = [];
      array.forEach(item => {
          let it = JSON.stringify(item);
          cellHide.push(it);
      });
      console.log("存储：", cellHide);
      localStorage.setItem(key,JSON.stringify(cellHide))
  }

}

