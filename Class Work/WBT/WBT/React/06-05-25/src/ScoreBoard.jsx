import { Component } from "react";

export class ScoreBoard extends Component {
  constructor() {
    super();
    //initilize this obj
    this.state = {
      score: 0,
    };
  }

  render() {
    return (
      <div>
        <h1>{this.state.score}</h1>
        <button onClick={}>+</button>
        <button>-</button>
      </div>
    );
  }
}
