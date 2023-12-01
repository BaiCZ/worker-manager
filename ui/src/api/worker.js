import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/emp',
    method: 'get',
    params
  })
}

export function deleteEmp(params) {
  return request({
    url: '/emp',
    method: 'delete',
    params
  })
}

export function editMsg(data) {
  return request({
    url: '/emp',
    method: 'put',
    data
  })
}

export function addMsg(data) {
  return request({
    url: '/emp',
    method: 'post',
    data
  })
}
