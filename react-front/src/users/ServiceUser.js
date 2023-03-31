import axios from "axios";

const baseUrl = "http://localhost:8000/";
class UserService {
  async getUser() {
    try {
      const response = await axios.get(`${baseUrl}/user`);
      return response.data;
    } catch (error) {
      console.error(error);
      return null;
    }
  }

  async getUserById(id) {
    try {
      const response = await axios.get(`${baseUrl}/user/${id}`);
      return response.data;
    } catch (error) {
      console.error(error);
      return null;
    }
  }

  async insertUser(user) {
    try {
      const response = await axios.post(`${baseUrl}/user/{id}`, user);
      return response.data;
    } catch (error) {
      console.error(error);
      return null;
    }
  }

  async updateUser(user, id) {
    try {
      const response = await axios.post(`${baseUrl}/user/{id}`, user);
      return response.data;
    } catch (error) {
      console.error(error);
      return null;
    }
  }


  async deleteUserById(id) {
    try {
      const response = await axios.delete(`${baseUrl}/user/${id}`);
      return response.data;
    } catch (error) {
      console.error(error);
      return null;
    }
  }
}
export default new UserService();