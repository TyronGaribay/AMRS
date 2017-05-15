public class Instruction {
	Vector instr;
	int stage;
	int stalled;
	String opcode;
	Object operand1;
	Object operand2;

	/*
		Stages:
		-1 - Stall
		0 - Fetch
		1 - Decode
		2 - Execute
		3 - Memory
		4 - Writeback
	*/
		
	public Instruction(Vector instr){
		this.instr = instr;
		this.stage = 0; // initialize to fetch
		this.stalled = -1;
	}

	public initialize(){
		this.opcode = this.instr.get(0);
		this.operand1 = this.instr.get(1);
		this.operand2 = this.instr.get(2);
	} 

	public void setOperand2(Object operand2){
		this.operand2 = operand2;
	}

	public void setOperand1(Object operand1){
		this.operand1 = operand1;
	}

	public void nextStage(){
		this.stage++;
	}

	public int getStage(){
		return this.stage;
	}

	public stall(){
		this.stalled = this.stage;
		this.stage = -1;
	}

	public restore(){
		this.stage = this.stalled + 1;
		this.stalled = -1;
	}
}