<<<<<<< HEAD
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ReactEcharts from 'echarts-for-react';

const NumOfStdsPerCity = () => {
  const [data, setData] = useState('');

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/auth/numberPerCity');
      console.log('=================');
      console.log(response.data);
      setData(response.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  // Extracting data for Echarts
  const cities = [];
  const studentCounts = [];

  if (data) {
    data.forEach(entry => {
      const [city, count] = Object.entries(entry)[0]; // Get the first key-value pair
      cities.push(city); // Push the city into the cities array
      studentCounts.push(count); // Push the count into the studentCounts array
    });
  }

  console.log(cities);
  console.log(studentCounts);

  const option = {
    title: {
      text: 'Number of Students in Each City',
    },
    tooltip: {},
    xAxis: {
      data: cities,
    },
    yAxis: {},
    series: [
      {
        name: 'Student Count',
        type: 'bar',
        data: studentCounts,
      },
    ],
  };

  return <ReactEcharts option={option} style={{ height: '400px' }} />;
};

export default NumOfStdsPerCity;
=======
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ReactEcharts from 'echarts-for-react';

const NumOfStdsPerCity = () => {
  const [data, setData] = useState('');

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/auth/numberPerCity');
      console.log('=================');
      console.log(response.data);
      setData(response.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  // Extracting data for Echarts
  const cities = [];
  const studentCounts = [];

  if (data) {
    data.forEach(entry => {
      const [city, count] = Object.entries(entry)[0]; // Get the first key-value pair
      cities.push(city); // Push the city into the cities array
      studentCounts.push(count); // Push the count into the studentCounts array
    });
  }

  console.log(cities);
  console.log(studentCounts);

  const option = {
    title: {
      text: 'Number of Students in Each City',
    },
    tooltip: {},
    xAxis: {
      data: cities,
    },
    yAxis: {},
    series: [
      {
        name: 'Student Count',
        type: 'bar',
        data: studentCounts,
      },
    ],
  };

  return <ReactEcharts option={option} style={{ height: '400px' }} />;
};

export default NumOfStdsPerCity;
>>>>>>> 9b287fc9961630ef346e59b8a1ae805c96f75917
