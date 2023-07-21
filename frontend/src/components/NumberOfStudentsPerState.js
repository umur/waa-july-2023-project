import ReactEcharts from "echarts-for-react";
import {useEffect, useState} from "react";
import axios from "axios";
export default function NumberOfStudentsPerState() {
    let [xSeries, setXSeries] = useState([])
    let [ySeries, setYSeries] = useState([])

    const option = {
        lazyUpdate: true,
        title: {
            text: "Number of students per state",
            show: true
        },
        xAxis: {
            type: 'category',
            data: xSeries
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                data: ySeries,
                type: 'bar'
            }
        ]
    }

    const getData = async () => {
        try {
            let result = await axios.get("/echart/numberOfStudentsPerState")
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
            alert("Getting data for numberOfStudentsPerState failed")
        }
    }
    useEffect(() => {
        getData();
    }, [])


    return <ReactEcharts option={option} forceUpdate={option}/>;
}