import axios from 'axios';
import qs from 'qs';

axios.defaults.timeout = 5000;
axios.defaults.baseURL ='';


//http request 拦截器
axios.interceptors.request.use(
    config => {
        // const token = getCookie('名称');注意使用的时候需要引入cookie方法，推荐js-cookie
        // config.data = JSON.stringify(config.data);
        // 此处设置header会导致全局使用此header, 无法自定义header
        // config.headers = {
        //   "Content-Type": "application/json;charset=UTF-8"
        // }
        // if(token){
        //   config.params = {'token':token}
        // }

        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

/**
 * 封装get方法
 * @param url
 * @param data
 * @returns {Promise}
 */

export function get(url,params={}){
  return new Promise((resolve,reject) => {
      axios.get(url,{
          params:params
      })
      .then(response => {
          resolve(response.data);
      })
      .catch(err => {
          reject(err);
      });
  });
};


/**
 * 封装post请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function post(url,data = {}){
    return new Promise((resolve,reject) => {
        axios.post(url,data)
        .then(response => {
            resolve(response.data);
        },err => {
            reject(err);
        });
    });
}

/**
 * 封装patch请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function patch(url,data = {}){
    return new Promise((resolve,reject) => {
        axios.patch(url,data)
        .then(response => {
            resolve(response.data);
        },err => {
            reject(err)
        });
    });
};

/**
 * 封装put请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function put(url,data = {}){
    return new Promise((resolve,reject) => {
        axios.put(url,data)
        .then(response => {
            resolve(response.data);
        },err => {
            reject(err);
        });
    });
};

/**
 * 封装delete请求
 * @param url
 * @param data
 * @returns {Promise}
 */

export function del(url,data = {}){
  return new Promise((resolve,reject) => {
    console.log(data);
    axios.delete(url,qs.stringify(data))
      .then(response => {
        resolve(response.data);
      },err => {
        reject(err);
      });
  });
};
