import request from '@/utils/request'

// 查询rsshub列表
export function listRsshub(query) {
  return request({
    url: '/data/rsshub/list',
    method: 'get',
    params: query
  })
}

// 查询rsshub详细
export function getRsshub(id) {
  return request({
    url: '/data/rsshub/' + id,
    method: 'get'
  })
}

// 新增rsshub
export function addRsshub(data) {
  return request({
    url: '/data/rsshub',
    method: 'post',
    data: data
  })
}

// 修改rsshub
export function updateRsshub(data) {
  return request({
    url: '/data/rsshub',
    method: 'put',
    data: data
  })
}

// 删除rsshub
export function delRsshub(id) {
  return request({
    url: '/data/rsshub/' + id,
    method: 'delete'
  })
}
