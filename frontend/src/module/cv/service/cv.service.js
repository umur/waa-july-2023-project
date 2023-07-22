import { api } from "../../../util/api";

const BASE_URL = "/cvs/";

function getList() {
  return api.get(BASE_URL);
}

function get(id) {
  return api.get(`${BASE_URL}${id}`);
}

function getForCreator(id, studentId) {
  return api.get(`${BASE_URL}${id}/student/${studentId}`);
}

function update(cv) {
  return api.put(`${BASE_URL}${cv.id.jobAdId}`, cv);
}

function deleteCv(id) {
  return api.delete(`${BASE_URL}${id.jobAdId}`);
}

function add(cv) {
  return api.post(BASE_URL, cv);
}

export const cvService = {
  getList,
  get,
  update,
  deleteCv,
  add,
  getForCreator
};
