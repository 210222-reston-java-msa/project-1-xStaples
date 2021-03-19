const genEmpListTable = () => {
	let xhr = new XMLHttpRequest;
	xhr.onreadystatechange = function() {
    if (this.readyState === 4 && this.status===200) {
        console.log("success");

		let tableItems = JSON.parse(xhr.responseText)
		console.log(tableItems.toString());
		
		mainPage.innerHTML = `
			<table>
			<tr>
			<td>
				<label for="">Request Id</label>
			</td>
			<td>
				<label for="">Request Amount</label>
			</td>
			<td>
				<label for="">Request Submitted</label>
			</td>
			<td>
				<label for="">Request Approved</label>
			</td>
			<td>
				<label for="">Request Description</label>
			</td>
			<td>
				<label for="">Request Author</label>
			</td>
			<td>
				<label for="">Request Resolver</label>
			</td>
			<td>
				<label for="">Request Status</label>
			</td>
			<td>
				<label for="">Request Type</label>
			</td>
			</tr>
			</table>`;
		}
	}
}