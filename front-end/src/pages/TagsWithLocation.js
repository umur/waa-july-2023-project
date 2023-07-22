import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ReactEcharts from 'echarts-for-react';

const TagsWithLocation = () => {
  const [data, setData] = useState('');

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('http://localhost:8080/auth/jobsAdvertisedPerState');
      console.log('=================');
      console.log(response.data);
      setData(response.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  // Extracting data for Echarts
  const states = [];
  const jobCounts = [];

  if (data) {
    data.forEach(entry => {
      const [state, count] = Object.entries(entry)[0]; // Get the first key-value pair
      states.push(state); // Push the city into the cities array
      jobCounts.push(count); // Push the count into the studentCounts array
    });
  }

  console.log(states);
  console.log(jobCounts);

  const option = {
    title: {
      text: 'Number of Tags in Each State',
    },
    tooltip: {},
    xAxis: {
      data: states,
    },
    yAxis: {},
    series: [
      {
        name: 'Tags Count',
        type: 'bar',
        data: jobCounts,
      },
    ],
  };

  return <ReactEcharts option={option} style={{ height: '400px' }} />;
};

export default TagsWithLocation;
