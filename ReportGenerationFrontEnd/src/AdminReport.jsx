import React, { PureComponent } from 'react';
import { PieChart,Pie,Tooltip } from 'recharts';
import {BarChart, Bar, XAxis, YAxis, CartesianGrid, Legend} from 'recharts';


 class AdminReport extends PureComponent {
     constructor(){
         super();
         this.state={
           data:[],
           month:'',
           year:'',
           frequentUserName:'',
           mostUsedSenderCurr:'',
           mostUsedReceiverCurr:''
         }
         this.handleSelectChange=this.handleSelectChange.bind(this);
     }

     getByYear=async(event)=>{
      const apiCall=await fetch(`http://localhost:8002/getYearlyReport`);
      const response = await apiCall.json();
      this.setState({
        data:response
      }
      )
     }

     async handleSelectChange(event){
      const {name,value}=event.target;
        this.setState({
            [name]:value
        })
      
     }
     handleSubmit=async(event)=>{
      event.preventDefault();
       const month=this.state.month;
       const year=this.state.year;
       console.log(month,year);
       const apiCall=await fetch(`http://localhost:8002/getDayWiseReport/${month}/${year}`);
      const response = await apiCall.json();
      this.setState({
        data:response
      }
      )
     }
     handleDateChange=async(event)=>{
       const apiCall=await fetch(`http://localhost:8002/getTransaction/${event.target.value}`);
      const response = await apiCall.json();
      console.log(response);
      this.setState({
      
      }
      )
     }

     getFrequentUser=async(event)=>{
      const apiCall=await fetch(`http://localhost:8002/getMostFrequentUser`);
      const response = await apiCall.json();
      console.log(response);
      this.setState({
        frequentUserName:response.entityName
      })
     }

     getMostUsedSenderCurrency=async(event)=>{
      const apiCall=await fetch(`http://localhost:8002/getMostUsedSenderCurrency`);
      const response = await apiCall.json();
      console.log(response);
      this.setState({
        mostUsedSenderCurr:response.entityName
      })
     }

     getMostUsedReceiverCurrency=async(event)=>{
      const apiCall=await fetch(`http://localhost:8002/getMostUsedReceiverCurrency`);
      const response = await apiCall.json();
      console.log(response);
      this.setState({
        mostUsedReceiverCurr:response.entityName
      })
     }
    
  render() {
    return (
        <div style={{textAlign:'center'}}>
          <h2>Forex Services</h2>
          <div className="App">
        <PieChart width={400} height={400}>
        <Pie
          dataKey="prof"
          isAnimationActive={true}
          data={this.state.data}
          cx="50%"
          cy="50%"
          outerRadius={80}
          fill="#8884d8"
          label="reportType"
        />
        <Tooltip />
      </PieChart>
      <BarChart
      width={500}
      height={300}
      isAnimationActive={true}
      data={this.state.data}
      margin={{
        top: 5,
        right: 30,
        left: 20,
        bottom: 5,
      }}
    >
      
          <XAxis dataKey="reportType" />
          <YAxis />
          <Tooltip />
          <Legend />
          <CartesianGrid strokeDasharray="3 3" />
          <Bar dataKey="prof" fill="#8884d8" background={{fill:"#eee"}}/>
        </BarChart>

        
    </div>
    <div>
    <button onClick={this.getByYear}> Get Report By Year</button>
    <form onSubmit={this.handleSubmit}>
        <select name="month" onChange={this.handleSelectChange} defaultValue="1">
                    <option value="1">January</option>
                    <option value="2">February</option>
                    <option value="3">March</option>
                    <option value="4">April</option>
                    <option value="5">May</option>
                    <option value="6">June</option>
                    <option value="7">July</option>
                    <option value="8">August</option>
                    <option value="9">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select><br/>
                <select name="year" onChange={this.handleSelectChange} defaultValue="2021">
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                </select>
                <button type="submit">Get</button>
                </form>
        <input type="date" onChange={this.handleDateChange}></input><br></br>
        <br/>
        <div className="App">
        <div style={{height:'auto',width:300,borderStyle:'groove'}}>
        <input type="button" className="button" onClick={this.getFrequentUser} value="Most Frequent User"></input>
        <h2>Most Frequent user is <br/>{this.state.frequentUserName}</h2>
        </div>
        <div style={{height:'auto',width:300,borderStyle:'groove'}}>
        <input type="button" className="button" onClick={this.getMostUsedSenderCurrency} value="Most used currency to send money"></input>
        <h2>Most used currency to send money is {this.state.mostUsedSenderCurr}</h2>
        </div>
        <div style={{height:'auto',width:300,borderStyle:'groove'}}>
        <input type="button" className="button" onClick={this.getMostUsedReceiverCurrency} value="Most used currency to receive money"></input>
        <h2>Most used currency to receive money {this.state.mostUsedReceiverCurr}</h2>
        </div>
        </div>
        </div>
    </div>
    );
  }
}

export default AdminReport;