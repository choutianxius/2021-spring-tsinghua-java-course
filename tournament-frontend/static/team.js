fetch('http://localhost:8091/tournament/team/list', {
    method: 'GET'
})
    .then(response => response.json())
    // .then(data => console.log(data))
    .then(data => fillTeams(data));

function fillTeams(teams) {
    let teamTable = document.getElementById('team-table');
    teams.forEach(element => fillTeam(teamTable, element));
}

function fillTeam(teamTable, team) {
    let convertedTeam = convertTeam(team);
    let row = teamTable.insertRow();
    let idCell = row.insertCell();
    idCell.innerHTML = convertedTeam.id;
    let nameCell = row.insertCell();
    nameCell.innerHTML = convertedTeam.name;
    let playerCountCell = row.insertCell();
    playerCountCell.innerHTML = convertedTeam.playerCount;
    let captainCell = row.insertCell();
    captainCell.innerHTML = convertedTeam.captain;
}

function convertTeam(team) {
    let convertedTeam = new Object();
    convertedTeam.id = team.id;
    convertedTeam.name = team.name;
    convertedTeam.playerCount = 0;

    team.members.forEach(element => {
        convertedTeam.playerCount++;
        if (element.captain === true) {
            convertedTeam.captain = element.player.name;
        }
    });

    return convertedTeam;
}


