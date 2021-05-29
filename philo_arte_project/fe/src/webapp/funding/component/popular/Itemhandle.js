import {React,useState} from "react";
import { useSelector , useDispatch} from "react-redux";
import {Link} from 'react-router-dom'
import { updateFunding } from "webapp/funding/reducer/funding.reducer";

const Itemhandle = ({ id, image, title, hashtag }) => {

  console.log("hashtag", hashtag)
  const dispatch = useDispatch()
  const [open, setOpen] = useState(false);

  const handleClose = () => setOpen(false)
  const handleOpen = async() =>{
    dispatch(updateFunding(id))
    setOpen(true)
    console.log(id)
  }

    return(
      <div className="col-md-3 mfp-iframe-holder ">
      
      <div className="portfolio-item"  onClick={handleOpen} >
        <img src='https://www.radiokorea.com/data/file/c_talk_pet/644496679_nXjx54Sc_4nnLaHCzm3n.jpg' />
        <div className="portfolio-info white-bg">
          <div className="centrize">
            <div className="v-center dark-color">
              <h3>{title}</h3>
              <p>{hashtag}</p>
            </div>
          </div>
        </div>
        </div>
      <updateFunding 
      open ={open} handleClose={() => handleClose() } 
      ></updateFunding>
    </div>
  );
}

export default Itemhandle;
