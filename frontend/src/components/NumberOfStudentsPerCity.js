import ReactEcharts from "echarts-for-react";
import {useEffect, useState} from "react";
import axios from "axios";
export default function NumberOfStudentsPerCity() {
    let [xSeries, setXSeries] = useState([])
    let [ySeries, setYSeries] = useState([])

    const option = {
        lazyUpdate: true,
        title: {
            text: "Number of students per city",
            show: true
        },
        xAxis: {
            type: 'category',
            axisLabel: { interval: 0, rotate: 30 },
            data: xSeries
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                data: ySeries,
                type: 'bar',
                datasetIndex:1
            }
        ]
    }

    const getData = async () => {
        try {
            let result = await axios.get("/echart/numberOfStudentsPerCity")
            let x=[]
            let y=[]
            Object.entries(result.data).forEach(key => {
                x.push(key[0]);
                y.push(key[1] * 1);
            })
            setXSeries(x);
            setYSeries(y);
            console.log(result)

        } catch(e) {
            alert("Getting data for numberOfStudentsPerCity failed")
        }
    }
    useEffect(() => {
        getData();
    }, [])


    return <ReactEcharts option={option} forceUpdate={option}/>;
}