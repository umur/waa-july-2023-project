import { api } from "../../../util/api";

const BASE_URL = "/job-ads/";

function getList() {
  return api.get(BASE_URL);
}

function get(id) {
  return api.get(`${BASE_URL}cv/${id}`);
}

function update(jobAd) {
  return api.put(`${BASE_URL}${jobAd.id}`, jobAd);
}
function add(jobAd) {
  return api.post(`${BASE_URL}`, jobAd);
}

function deleteJobAd(id) {
  return api.delete(`${BASE_URL}${id}`);
}

export const jobAdService = {
  getList,
  get,
  update,
  add,
  deleteJobAd
};
